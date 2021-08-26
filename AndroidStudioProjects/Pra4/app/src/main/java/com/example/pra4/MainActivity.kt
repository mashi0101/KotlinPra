package com.example.pra4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_order).setOnClickListener{
            val intent = Intent(this,SecActivity::class.java)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int,resultCode: Int, data:Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode,resultCode,data)

        data?.extras?.let{
            if(requestCode ==1 && requestCode == Activity.RESULT_OK){
                findViewById<TextView>(R.id.meal).text=
                    "飲料：${it.getString("drink")}\n\n"
                    "甜度：${it.getString("sweet")}\n\n"
                    "冰塊：${it.getString("ice")}"
            }
        }
    }
}