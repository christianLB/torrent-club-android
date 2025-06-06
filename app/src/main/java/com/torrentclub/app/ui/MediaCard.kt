package com.torrentclub.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.torrentclub.app.model.TmdbItem

private const val TMDB_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"

@Composable
fun MediaCard(item: TmdbItem, modifier: Modifier = Modifier) {
    val imageUrl = item.posterPath?.let {
        if (it.startsWith("http")) it else TMDB_IMAGE_BASE_URL + "w342" + it
    }

    Card(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(6.dp)),
        colors = CardDefaults.cardColors()
    ) {
        if (imageUrl != null) {
            AsyncImage(
                model = imageUrl,
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            )
        }
    }
}
