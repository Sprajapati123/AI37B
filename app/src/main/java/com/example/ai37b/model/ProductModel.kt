package com.example.ai37b.model

data class ProductModel(
    var productId : String = "",
    var name : String = "",
    var price : Double = 0.0,
    var description : String = "",
    var imageUrl : String = "",
    var categoryId : String = ""
){
    fun toMap() : Map<String,Any?>{
        return mapOf(
            "name" to name,
            "price" to price,
            "description" to description,
            "imageUrl" to imageUrl,
            "categoryId" to categoryId,
        )
    }
}


