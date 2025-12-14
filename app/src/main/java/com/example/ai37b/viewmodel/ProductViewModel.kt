package com.example.ai37b.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ai37b.model.ProductModel
import com.example.ai37b.repository.ProductRepo

class ProductViewModel(val repo: ProductRepo) : ViewModel() {


    fun addProduct(model: ProductModel, callback: (Boolean, String) -> Unit) {
        repo.addProduct(model, callback)
    }

    fun updateProduct(model: ProductModel, callback: (Boolean, String) -> Unit) {
        repo.updateProduct(model, callback)
    }

    fun deleteProduct(productId: String, callback: (Boolean, String) -> Unit) {
        repo.deleteProduct(productId, callback)
    }

    private val _products = MutableLiveData<ProductModel?>()
    val products: MutableLiveData<ProductModel?> get() = _products


    private val _allProducts = MutableLiveData<List<ProductModel>?>()
    val allProducts: MutableLiveData<List<ProductModel>?> get() = _allProducts

    fun getProductById(productId: String) {
        repo.getProductById(productId) { success, msg, data ->
            if (success) {
                _products.postValue(data)
            } else {
                _products.postValue(data)

            }
        }
    }

    fun getAllProduct() {
        repo.getAllProduct { success, msg, data ->
            if (success) {
                _allProducts.postValue(data)
            } else {
                _allProducts.postValue(data)

            }
        }
    }

//    fun getProductByCategory(
//        categoryId: String,
//        callback: (Boolean, String, List<ProductModel>?) -> Unit
//    )
}