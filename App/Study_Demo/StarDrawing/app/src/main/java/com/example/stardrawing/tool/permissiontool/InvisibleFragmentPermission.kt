package com.example.stardrawing.tool.permissiontool

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

typealias PermissionCallback = (Boolean, List<String>) -> Unit//Permission callback fun struct

@Suppress("DEPRECATION")
class InvisibleFragmentPermission : Fragment() {

    private var callback: PermissionCallback? = null
    //Set call values to output result for request just now
    private val PERMISSION_SUBMIT_GO = 1

    fun requestNow(cb: PermissionCallback, vararg permissions: String) {
        callback = cb// Init callback low fun struct and get permission we want submit
        requestPermissions(permissions, PERMISSION_SUBMIT_GO)
        //Use Fragment's fun to request Permissions
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {//if request return result

        if (requestCode == PERMISSION_SUBMIT_GO) {//if return our requestCode
            val deniedList = ArrayList<String>()//Init Error report

            for ((index, result) in grantResults.withIndex()) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    deniedList.add(permissions[index])//add report
                }
            }

            callback?.let {
                it(deniedList.isEmpty(), deniedList)//Update report and Error or not
                /* it's submit success or not and Error report*/
            }

        }

    }

}