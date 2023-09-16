package com.example.stardrawing.mainview.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stardrawing.R
import com.example.stardrawing.base.BaseFragment
import com.example.stardrawing.tool.`interface`.MainViewCallBack

class CommunityFragment:BaseFragment(){

    private lateinit var mainViewCallBack: MainViewCallBack
    private var judgeSuccess:Boolean=false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_community,container,false)
    }

}