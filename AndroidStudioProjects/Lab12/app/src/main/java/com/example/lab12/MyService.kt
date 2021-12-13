package com.example.lab12

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    //僅在執行時啟動
    override fun onCreate() {
        super.onCreate()
    }

    //每次啟動都呼叫
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        //終止Service，進入Service類別的onDestroy()
        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder?= null
}