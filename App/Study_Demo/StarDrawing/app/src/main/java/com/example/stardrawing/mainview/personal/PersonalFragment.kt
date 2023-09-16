package com.example.stardrawing.mainview.personal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stardrawing.R
import com.example.stardrawing.base.BaseFragment
import com.example.stardrawing.tool.`interface`.MainViewCallBack

class PersonalFragment:BaseFragment(){

    private lateinit var mainViewCallBack: MainViewCallBack

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_personal,container,false)
    }

}