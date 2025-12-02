package com.example.ai37b

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
    val images = listOf(
        R.drawable.face,
        R.drawable.gmail,
        R.drawable.bettafish,
        R.drawable.cat,
        R.drawable.dog,
        R.drawable.fish,
        R.drawable.goldfish,
        R.drawable.guineapig,
    )
    val names = listOf(
        "Facebook",
        "Gmail",
        "Bettafish",
        "Cat",
        "Dog",
        "Fish",
        "Goldfish",
        "Guineapig",
    )
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

       item {
           Text("Hello")
           Text("Good Afternoon")

           LazyRow {
               items(images.size){index->
                   Column {
                       Image(
                           painter = painterResource(images[index]),
                           contentDescription = null,
                           modifier = Modifier.size(70.dp).padding(end = 10.dp)
                       )
                       Text(names[index])
                   }
               }
           }

          Image(
              painter = painterResource(R.drawable.banner),
              contentDescription = null,
              modifier = Modifier.fillMaxWidth(),
              contentScale = ContentScale.Crop
          )

       }

        item {
            Text("Trending products")
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(500.dp)
            ) {
                items(images.size){index->
                    Image(
                        painter = painterResource(images[index]),
                        contentDescription = null,
                        modifier = Modifier.size(70.dp).padding(end = 10.dp)
                    )
                }

            }
        }




    }
}