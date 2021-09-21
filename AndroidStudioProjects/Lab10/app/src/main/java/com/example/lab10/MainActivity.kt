package com.example.lab10

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //將動畫的drawable指定為ImageView的背景資源
        val img_loading = findViewById<ImageView>(R.id.img_loading)
        img_loading.setBackgroundResource(R.drawable.frame_animation)
        findViewById<Button>(R.id.btn_start).setOnClickListener{
            //將圖片背景轉為AnimationDrawable類別並執行
            val animation = img_loading.background as AnimationDrawable
            animation.start()
        }
        findViewById<Button>(R.id.btn_stop).setOnClickListener{
            //將圖片背景轉為AnimationDrawable類別並停止
            val animation = img_loading.background as AnimationDrawable
            animation.stop()
        }
    }
}