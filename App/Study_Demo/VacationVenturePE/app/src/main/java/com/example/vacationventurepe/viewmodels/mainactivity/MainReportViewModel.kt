package com.example.vacationventurepe.viewmodels.mainactivity

import com.example.vacationventurepe.viewmodels.BaseViewModel

class MainReportViewModel : BaseViewModel() {

    init{
        text.value = "This is report fragment"
        refreshText()
    }

}