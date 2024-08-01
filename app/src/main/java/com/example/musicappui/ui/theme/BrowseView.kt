package com.example.musicappui.ui.theme

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.example.musicappui.R

@Composable
fun Browse(){
    val categories = listOf<String>("Hits","Feel good", "Sad","Workout","Meditation","Happy","Lofi","Relaxing","Party Song","Classical")
    LazyVerticalGrid(columns =GridCells.Fixed(2) ){
        items(categories){
            cat->
            BrowserItem(cat = cat, drawable = R.drawable.ic_music_player)
        }
    }
}