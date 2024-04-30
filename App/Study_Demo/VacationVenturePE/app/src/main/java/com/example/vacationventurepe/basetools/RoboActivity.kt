package com.example.vacationventurepe.basetools

import android.content.Intent
import android.os.Bundle
import java.util.Timer
import java.util.TimerTask

object RoboActivity {

   inline fun<reified T:BaseActivity> BaseActivity.roboStartActivity(paramList:List<Pair<String,String>>?,addBundle:Bundle?,launchType:Int){
       val intent = Intent(this,T::class.java)

       val activity = this

       paramList?.let {
           for(parma in paramList){

               intent.putExtra(parma.first,parma.second)

           }
       }


       if (addBundle != null) {
           startActivity(intent, addBundle)
       } else {
           startActivity(intent)
       }

       Timer().schedule(object : TimerTask(){
           override fun run() {
               when (launchType) {
                   Base.START_TYPE_FINISH -> {
                       finishWithAnimation(activity)
                   }
               }
           }
       },2000)



   }



}