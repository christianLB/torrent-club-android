package com.torrentclub.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.torrentclub.app.model.CarouselItem
import com.torrentclub.app.model.Category
import com.torrentclub.app.network.ApiService
import kotlinx.coroutines.launch

class FeaturedViewModel : ViewModel() {
    var carouselItems by mutableStateOf<List<CarouselItem>>(emptyList())
        private set

    var categories by mutableStateOf<List<Category>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    private val api = ApiClient.retrofit.create(ApiService::class.java)

    init {
        viewModelScope.launch { loadData() }
    }

    private suspend fun loadData() {
        try {
            isLoading = true
            carouselItems = api.getCarousel()
            categories = api.getFeatured()
            error = null
        } catch (e: Exception) {
            error = e.message
        } finally {
            isLoading = false
        }
    }
}
