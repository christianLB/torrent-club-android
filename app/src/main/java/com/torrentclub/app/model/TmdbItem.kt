package com.torrentclub.app.model

import com.google.gson.annotations.SerializedName

data class TmdbItem(
    @SerializedName("tmdbId") val tmdbId: Int,
    val title: String?,
    @SerializedName("posterPath") val posterPath: String?,
    @SerializedName("backdropPath") val backdropPath: String?,
    val overview: String?,
    val mediaType: String
)
