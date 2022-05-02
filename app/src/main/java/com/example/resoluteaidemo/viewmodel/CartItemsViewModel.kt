package com.example.resoluteaidemo.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resoluteaidemo.model.CartItemsData
import com.google.android.material.snackbar.Snackbar

class CartItemsViewModel : ViewModel() {
   private val count:MutableLiveData<Int> = MutableLiveData(1)
   private val price:MutableLiveData<Double> = MutableLiveData(95.97)

    val _count get() = count
    val _price get() = price




    fun decreaseQuantity(view: View?) {
        count.value= count.value?.minus(1)
    }

    fun increasePrice(item:CartItemsData){
        price.value=price.value?.plus(item.price.toDouble())
    }
    fun decreasePrice(item:CartItemsData){
        price.value=price.value?.minus(item.price.toDouble())
    }

    fun resetCount(){
        count.value=1
    }

    fun increaseItemQty(){
        count.value= count.value?.plus(1)
    }
}