@file:Suppress("DEPRECATION")

package com.example.stardrawing.base

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TimFragmentPagerAdapter(
    timFragmentList: ArrayList<BaseFragment>,
    timFragmentManager: FragmentManager?
) : FragmentPagerAdapter(timFragmentManager!!) {

    private val fragmentList = timFragmentList


    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun startUpdate(container: ViewGroup) {
        super.startUpdate(container)
    }

    override fun getCount(): Int = fragmentList.size



}