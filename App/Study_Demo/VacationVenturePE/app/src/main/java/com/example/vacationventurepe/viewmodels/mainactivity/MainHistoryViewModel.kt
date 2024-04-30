package com.example.vacationventurepe.viewmodels.mainactivity

import com.example.vacationventurepe.viewmodels.BaseViewModel

class MainHistoryViewModel : BaseViewModel() {
    init {
        text.value = "This is history fragment"
        refreshText()
    }

}