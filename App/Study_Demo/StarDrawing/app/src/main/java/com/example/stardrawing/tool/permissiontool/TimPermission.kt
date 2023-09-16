package com.example.stardrawing.tool.permissiontool

import androidx.fragment.app.FragmentActivity

object TimPermission {

    private const val TAG = "InvisibleFragment"

    fun request(
        activity: FragmentActivity, vararg permission: String,
        callback: PermissionCallback
    ) {

        val fragmentManager = activity.supportFragmentManager
        val exitedFragment = fragmentManager.findFragmentByTag(TAG)

        val fragment = if(exitedFragment!=null){
            exitedFragment as InvisibleFragmentPermission
        }else{
            val invisibleFragmentPermission=InvisibleFragmentPermission()
            fragmentManager.beginTransaction().add(invisibleFragmentPermission,TAG).commitNow()
            invisibleFragmentPermission
        }

        fragment.requestNow(callback,*permission)

    }



}