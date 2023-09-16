package com.example.stardrawing.mainview.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.stardrawing.R
import com.example.stardrawing.base.BaseFragment
import com.example.stardrawing.base.TimDepthPageTransformer
import com.example.stardrawing.base.TimFragmentPagerAdapter
import com.example.stardrawing.mainview.board.BoardFragment
import com.example.stardrawing.mainview.center.CenterFragment
import com.example.stardrawing.mainview.community.CommunityFragment
import com.example.stardrawing.mainview.painting.PaintingFragment
import com.example.stardrawing.mainview.personal.PersonalFragment
import com.example.stardrawing.tool.`interface`.MainViewCallBack


/*
重构日期：2023.04.19
功能：一个依赖在主页面上的Fragment，主要利用了ViewPager实现了左右滑动切换主界面功能
公用方法：外部调用replaceFragment（）方法实现自动切换主界面
 */
@Suppress("DEPRECATION")
class MainViewMainFrag : BaseFragment(), ViewPager.OnPageChangeListener {

    private lateinit var fragmentList: ArrayList<BaseFragment>
    private lateinit var fragmentViewPager: ViewPager

    private lateinit var attachActivity: MainViewCallBack


    /******重载方法******/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mainview_mainfrag, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVar(view)

    }

    override fun onPageSelected(position: Int) {
        attachActivity.mainViewMainFragCallBack(position)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is MainViewCallBack){
            attachActivity=context
        }
    }



    /******自定义方法******/
    /*
    功能：实例化该fragment中的所有组件，配置ViewPager的适配器和具体Fragment
     */
    private fun initVar(view: View) {

        /******实例化五个中心Fragment******/
        fragmentList = ArrayList(5)
        fragmentList.add(BoardFragment())
        fragmentList.add(PaintingFragment())
        fragmentList.add(CenterFragment())
        fragmentList.add(CommunityFragment())
        fragmentList.add(PersonalFragment())

        //找到这个Fragment中管理viewPager的组件
        fragmentViewPager = view.findViewById(R.id.mainview_viewpager)

        //适配ViewPager的适配器
        fragmentViewPager.adapter = TimFragmentPagerAdapter(fragmentList, fragmentManager)
        fragmentViewPager.setPageTransformer(true, TimDepthPageTransformer())
        //默认界面
        fragmentViewPager.currentItem = 2

        fragmentViewPager.addOnPageChangeListener(this)

    }

    fun replaceFragment(text:Int) {
        fragmentViewPager.currentItem = text
    }

}