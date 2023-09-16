package com.example.stardrawing.mainview.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.stardrawing.R
import com.example.stardrawing.base.BaseFragment
import com.example.stardrawing.tool.TotalVal
import com.example.stardrawing.tool.`interface`.MainViewCallBack

/*
重构日期：2023.4.19
功能：依赖于MainViewBus上的底部导航栏，负责响应主界面的导航点击事件，并且同步MainViewMainFrag的手势滑动切换主界面
 */

class MainViewBottomGuide : BaseFragment() {

    private lateinit var guideCenterBtn: Button
    private lateinit var guideBoardBtn: Button
    private lateinit var guidePaintingBtn: Button
    private lateinit var guideCommunityBtn: Button
    private lateinit var guidePersonalBtn: Button

    private lateinit var isCheckedList: ArrayList<Boolean>

    private lateinit var centerBtnBackground: ImageView

    private lateinit var attachActivity: MainViewCallBack


    /******重载方法******/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mainview_bottomguide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVar(view)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainViewCallBack){
            attachActivity=context
        }
    }


    /******自定义方法******/
    /*
    功能：拉取布局中的控件，实例化底部导航栏的状态数组
     */
    private fun initVar(view: View) {

        //拉取布局按钮控件
        guideCenterBtn = view.findViewById(R.id.mainview_bottomguide_CenterBtn)
        guideBoardBtn = view.findViewById(R.id.mainview_bottomguide_BoardBtn)
        guideCommunityBtn = view.findViewById(R.id.mainview_bottomguide_CommunityBtn)
        guidePaintingBtn = view.findViewById(R.id.mainview_bottomguide_PaintBtn)
        guidePersonalBtn = view.findViewById(R.id.mainview_bottomguide_PersonalBtn)

        centerBtnBackground = view.findViewById(R.id.mainview_bottomguide_BtnView)


        //实例化按钮状态数组
        isCheckedList = ArrayList(5)
        repeat(5) {
            isCheckedList.add(false)
        }
        isCheckedList[TotalVal.REPLACE_TO_CENTER_FRAGMENT] = true



        //设置按钮监听
        guideBoardBtn.setOnClickListener {
            changeIconAndState(TotalVal.REPLACE_TO_BOARD_FRAGMENT)
            attachActivity.mainViewBottomGuideCallBack(TotalVal.REPLACE_TO_BOARD_FRAGMENT)
        }

        guidePaintingBtn.setOnClickListener {
            changeIconAndState(TotalVal.REPLACE_TO_PAINTING_FRAGMENT)
            attachActivity.mainViewBottomGuideCallBack(TotalVal.REPLACE_TO_PAINTING_FRAGMENT)
        }

        guideCenterBtn.setOnClickListener {
            changeIconAndState(TotalVal.REPLACE_TO_CENTER_FRAGMENT)
            attachActivity.mainViewBottomGuideCallBack(TotalVal.REPLACE_TO_CENTER_FRAGMENT)
        }

        guideCommunityBtn.setOnClickListener {
            changeIconAndState(TotalVal.REPLACE_TO_COMMUNITY_FRAGMENT)
            attachActivity.mainViewBottomGuideCallBack(TotalVal.REPLACE_TO_COMMUNITY_FRAGMENT)
        }

        guidePersonalBtn.setOnClickListener {
            changeIconAndState(TotalVal.REPLACE_TO_PERSONAL_FRAGMENT)
            attachActivity.mainViewBottomGuideCallBack(TotalVal.REPLACE_TO_PERSONAL_FRAGMENT)
        }

    }

    /*
    功能：改变被点击按钮的状态数组和图标
     */
    fun changeIconAndState(index: Int) {
        if (!isCheckedList[index]) {
            exceptList(index)
            exceptIcon(index)

        }
    }

    /*
    功能：改变被点击按钮的状态数组
     */
    private fun exceptList(index: Int) {
        isCheckedList.fill(false)
        isCheckedList[index] = true
    }

    /*
    功能：该函数在exceptList()函数的基础上对应用图标重改
     */
    private fun exceptIcon(index: Int) {

        guideBoardBtn.setBackgroundResource(R.drawable.main_view_boardbtn_disable)
        guidePaintingBtn.setBackgroundResource(R.drawable.main_view_paintingbtn_disable)
        guideCommunityBtn.setBackgroundResource(R.drawable.main_view_communitybtn_disable)
        guidePersonalBtn.setBackgroundResource(R.drawable.main_view_personalbtn_disable)

        centerBtnBackground.setBackgroundResource(R.drawable.main_view_centerbtn_backview_disable)

        when (index) {

            TotalVal.REPLACE_TO_BOARD_FRAGMENT -> guideBoardBtn.setBackgroundResource(R.drawable.main_view_boardbtn_able)
            TotalVal.REPLACE_TO_PAINTING_FRAGMENT -> guidePaintingBtn.setBackgroundResource(R.drawable.main_view_paintingbtn_able)
            TotalVal.REPLACE_TO_CENTER_FRAGMENT -> centerBtnBackground.setBackgroundResource(R.drawable.main_view_centerbtn_backview_able)
            TotalVal.REPLACE_TO_COMMUNITY_FRAGMENT -> guideCommunityBtn.setBackgroundResource(R.drawable.main_view_communitybtn_able)
            TotalVal.REPLACE_TO_PERSONAL_FRAGMENT -> guidePersonalBtn.setBackgroundResource(R.drawable.main_view_personalbtn_able)

        }

    }

}