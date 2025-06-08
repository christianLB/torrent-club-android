package com.torrentclub.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.torrentclub.app.model.CarouselItem
import kotlinx.coroutines.launch

private const val TMDB_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedCarousel(items: List<CarouselItem>) {
    val pagerState = rememberPagerState(pageCount = { items.size })
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(240.dp)) {
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
            val item = items[page]
            val imageUrl = item.backdropPath?.let {
                if (it.startsWith("http")) it else TMDB_IMAGE_BASE_URL + "w780" + it
            } ?: item.posterPath?.let {
                if (it.startsWith("http")) it else TMDB_IMAGE_BASE_URL + "w500" + it
            }
            Box(modifier = Modifier.fillMaxSize()) {
                if (imageUrl != null) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = item.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color.Black.copy(alpha = 0.6f), Color.Transparent)
                            )
                        )
                )
                Box(modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)) {
                    Text(
                        text = item.title ?: "",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                }
            }
        }
    }
}
