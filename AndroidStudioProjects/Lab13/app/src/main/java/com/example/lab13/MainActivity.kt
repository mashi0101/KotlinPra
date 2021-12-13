package com.example.lab13

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //Step1:建立BroadcastReceiver物件
    private val receiver = object : BroadcastReceiver() {
        //Step2:在onReceive()中加入接收廣播後要執行的動作
        override fun onReceive(context: Context, intent: Intent) {
            intent.extras?.let {
                //解析intent取得字串訊息
                val msg = "資料:${it.getString("msg")}"
                Toast.makeText(context, "螢幕開啟", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Step3:建立IntentFilter物件，並指定接收的識別標籤為MyBroadcast
        val intentFilter = IntentFilter("MyBroadcast")
        //Step4:註冊Receiver
        registerReceiver(receiver,intentFilter)
    }
}