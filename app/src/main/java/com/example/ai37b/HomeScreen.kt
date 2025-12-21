package com.example.ai37b

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.ai37b.model.ProductModel
import com.example.ai37b.repository.ProductRepoImpl
import com.example.ai37b.ui.theme.Blue
import com.example.ai37b.ui.theme.PurpleGrey80
import com.example.ai37b.viewmodel.ProductViewModel


@Composable
fun HomeScreen() {
    val productViewModel = remember { ProductViewModel(ProductRepoImpl()) }
    var showDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val data = productViewModel.products.observeAsState(initial = null)
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }

    LaunchedEffect(data.value) {
        productViewModel.getAllProduct()

        data.value?.let { product ->
            name = product.name
            price = product.price.toString()
            desc = product.description
        }
    }

    val products = productViewModel.allProducts.observeAsState(initial = emptyList())
    val loading = productViewModel.loading.observeAsState(initial = false)




    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            if (showDialog) {
                AlertDialog(
                    confirmButton = {
                        TextButton(onClick = {
                            var model = ProductModel(
                                data.value!!.productId,
                                name,
                                price.toDouble(),
                                desc,
                                ""
                            )
                            productViewModel.updateProduct(model) { success, message ->
                                if (success) {
                                    showDialog = false
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                } else {
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                }
                            }
                        }) {
                            Text("Update")
                        }
                    },
                    onDismissRequest = {
                        showDialog = false
                    },
                    title = {
                        Text("Update Product")
                    },
                    text = {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                value = name,
                                onValueChange = { data ->
                                    name = data
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                shape = RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product name")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Email
                                ),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Blue,
                                    unfocusedIndicatorColor = Blue
                                )

                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                value = price,
                                onValueChange = { data ->
                                    price = data
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                shape = RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product Price")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Email
                                ),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Blue,
                                    unfocusedIndicatorColor = Blue
                                )

                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            OutlinedTextField(
                                value = desc,
                                onValueChange = { data ->
                                    desc = data
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 15.dp),
                                shape = RoundedCornerShape(15.dp),
                                placeholder = {
                                    Text("Product Description")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Email
                                ),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = PurpleGrey80,
                                    unfocusedContainerColor = PurpleGrey80,
                                    focusedIndicatorColor = Blue,
                                    unfocusedIndicatorColor = Blue
                                )

                            )
                            Spacer(modifier = Modifier.height(20.dp))

                        }
                    }

                )
            }

        }
        if(loading.value){
            item {
                CircularProgressIndicator()
            }
        }else{
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
                        AsyncImage(
                            model = data.imageUrl,
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)

                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(20.dp)
                        ) {
                            Text(data.name)
                            Text(data.price.toString())
                            Text(data.description)

                        }
                        Column() {
                            IconButton(onClick = {
                                showDialog = true
                                productViewModel.getProductById(data.productId)
                            }) {
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
}