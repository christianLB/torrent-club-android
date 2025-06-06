package com.torrentclub.app.network

import com.torrentclub.app.model.CarouselItem
import com.torrentclub.app.model.Category
import retrofit2.http.GET

interface ApiService {
    @GET("api/featured/carousel-content")
    suspend fun getCarousel(): List<CarouselItem>

    @GET("api/featured")
    suspend fun getFeatured(): List<Category>
}
