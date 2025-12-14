package com.example.ai37b.repository

import com.example.ai37b.model.ProductModel

interface ProductRepo {

    //    {
//        "success":true,
//        "message" : "Product deleted succesfully"
//    }
    fun addProduct(model: ProductModel, callback: (Boolean, String) -> Unit)

    fun updateProduct(model: ProductModel, callback: (Boolean, String) -> Unit)

    fun deleteProduct(productId: String, callback: (Boolean, String) -> Unit)

    fun getProductById(productId: String, callback: (Boolean, String, ProductModel?) -> Unit)

    fun getAllProduct(callback: (Boolean, String, List<ProductModel>?) -> Unit)

    fun getProductByCategory(
        categoryId: String,
        callback: (Boolean, String, List<ProductModel>?) -> Unit
    )
}