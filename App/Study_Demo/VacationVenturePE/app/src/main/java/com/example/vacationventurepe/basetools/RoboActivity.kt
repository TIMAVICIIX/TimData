package com.example.vacationventurepe.basetools

import android.content.Intent
import android.os.Bundle
import java.util.Timer
import java.util.TimerTask

object RoboActivity {

    /**
     * @param paramList intent的参数列表
     * @param addBundle 为唤醒的Activity加入的参数，实际上就是intent
     * @param launchType 启动模式，有结束自身与不结束自身的选择 Base.START_TYPE_FINISH结束自身与Base.START_TYPE_STAYME不结束自身
     * */
    inline fun <reified T : BaseActivity> BaseActivity.roboStartActivityWithFinishChoose(
        paramList: List<Pair<String, String>>?,
        addBundle: Bundle?,
        launchType: Int
    ) {
        val intent = Intent(this, T::class.java)

        val activity = this

        paramList?.let {
            for (parma in paramList) {
                intent.putExtra(parma.first, parma.second)
            }
        }


        if (addBundle != null) {
            startActivity(intent, addBundle)
        } else {
            startActivity(intent)
        }


        when (launchType) {
            Base.START_TYPE_FINISH -> {
                Timer().schedule(object:TimerTask(){
                    override fun run() {
                        finishWithAnimation(activity)
                    }
                },1000)

            }
        }
    }

    inline fun <reified T : BaseActivity> BaseActivity.roboStartActivity() {
        //TODO

    }
}





