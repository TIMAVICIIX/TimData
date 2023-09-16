package com.example.stardrawing.mainview.main

import android.os.Bundle
import android.view.KeyEvent
import com.example.stardrawing.R
import com.example.stardrawing.base.BaseActivity
import com.example.stardrawing.tool.`interface`.MainViewCallBack

/*
重构日期：2023.4.19
功能：是MainViewMainFrag与MainViewBottomGuide两个Fragment的依赖Activity，用于两个Fragment或者后期多个Fragment
之间的信息通信，用于绑定各主界面Fragment的生命周期，用于Fragment与Activity，与外界的信息交互和信息整理与分配
 */

class MainViewBus : BaseActivity(), MainViewCallBack {

    private lateinit var bottomGuide: MainViewBottomGuide
    private lateinit var mainFrag: MainViewMainFrag

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainview_bus)

        //拉取Fragment控件
        bottomGuide =
            supportFragmentManager.findFragmentById(R.id.mainview_bottomguide)!! as MainViewBottomGuide
        mainFrag =
            supportFragmentManager.findFragmentById(R.id.mainview_mainfrag)!! as MainViewMainFrag


    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (supportFragmentManager.backStackEntryCount != 0) {
                supportFragmentManager.popBackStack()
            } else {
                exitDouble(2000, "再按一次退出应用")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    /*
    功能：收到来自底部导航栏的信息，并做出相应操作
     */
    override fun mainViewBottomGuideCallBack(text: Int) {
        mainFrag.replaceFragment(text)
    }

    /*
    功能：收到来自主Fragment的信息，并做出相应操作
     */
    override fun mainViewMainFragCallBack(text: Int) {
        bottomGuide.changeIconAndState(text)
    }

}