package com.torrentclub.app.model

import com.google.gson.annotations.SerializedName

/** Category of featured items */
data class Category(
    val id: String,
    val title: String,
    val items: List<TmdbItem>
)
