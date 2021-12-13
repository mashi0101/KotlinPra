package com.example.lab16_2

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Step1:建立ContentValues物件，用於存放要新增的資料
        val values = ContentValues()
        //book欄位填入恐龍書
        values.put("book", "恐龍書")
        //price欄位填入1400
        values.put("price", 1400)
        //Step2:透過insert()放入Uri及ContentValues讓provider新增資料
        val uri = Uri.parse("content://com.italkutalk.lab16")
        val contentUri = contentResolver.insert(uri, values)
        //Step3:判斷回傳此筆紀錄Uri是否為null，以確認資料新增是否成功
        if (contentUri != null)
            Toast.makeText(this, "新增:恐龍書,價格:1400",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, "新增失敗",Toast.LENGTH_LONG).show()
    }
}