package com.example.myapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        if (it == 1){
            "This tab is for Address"
        }
        else if (it == 2){
            "This tab is for Gallery"
        }
        else{
            "This tab is for free"
        }
    }


    fun setIndex(index: Int) {
        _index.value = index
    }


}