package com.caldremch.andorid.architecture.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    private val _listData = MutableLiveData<List<String>>()
    val text: LiveData<String> = _text
    val listData: LiveData<List<String>> = _listData

    fun setList(list:List<String>){
        _listData.value = list
    }
}