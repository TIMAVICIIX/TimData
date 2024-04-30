package com.example.vacationventurepe.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    open val text = MutableLiveData<String>().apply {
        value = "This is base Fragment"
    }
    open var showText: LiveData<String> = text

    open fun refreshText() {

        showText = text

    }

}