package com.torrentclub.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.torrentclub.app.FeaturedViewModel

@Composable
fun FeaturedScreen(viewModel: FeaturedViewModel = viewModel()) {
    val isLoading = viewModel.isLoading
    val error = viewModel.error
    val carouselItems = viewModel.carouselItems
    val categories = viewModel.categories

    when {
        isLoading -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        error != null -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = error ?: "Error", color = MaterialTheme.colorScheme.error)
        }
        else -> {
            LazyColumn {
                item {
                    if (carouselItems.isNotEmpty()) {
                        FeaturedCarousel(carouselItems)
                    }
                }
                items(categories) { category ->
                    CategoryRow(category)
                }
            }
        }
    }
}
