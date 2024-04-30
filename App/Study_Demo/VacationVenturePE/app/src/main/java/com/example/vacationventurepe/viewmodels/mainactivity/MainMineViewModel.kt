package com.example.vacationventurepe.viewmodels.mainactivity

import com.example.vacationventurepe.viewmodels.BaseViewModel

class MainMineViewModel : BaseViewModel() {
    init {
        text.value = "This is mine fragment"
        refreshText()
    }

}