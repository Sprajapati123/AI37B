package com.example.ai37b

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ai37b.repository.ProductRepoImpl
import com.example.ai37b.viewmodel.ProductViewModel


@Composable
fun HomeScreen() {
    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        productViewModel.getAllProduct()
    }

    val products = productViewModel.allProducts.observeAsState(initial = emptyList())


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(products.value!!.size) { index ->
            var data = products.value!![index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier.weight(1f).padding(20.dp)
                    ) {
                        Text(data.name)
                        Text(data.price.toString())
                        Text(data.description)

                    }
                    Column() {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Edit,
                                contentDescription = null,
                                tint = Color.Gray
                            )
                        }
                        IconButton(onClick = {
                            productViewModel.deleteProduct(data.productId) { success, message ->
                                if (success) {
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

                                }
                            }
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = null, tint = Color.Red)
                        }
                    }
                }
            }
        }

    }
}