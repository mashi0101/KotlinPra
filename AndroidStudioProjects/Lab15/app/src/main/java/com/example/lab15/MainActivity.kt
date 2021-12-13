package com.example.lab15

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //使用writableDatabase屬性建立可寫入的資料庫
        val dbrw = MyDBHelper(this).writableDatabase

        //Step1:建立ContentValues物件，存放新增資料
        val cv1 = ContentValues()
        cv.put("book","百科全書")
        cv.put("price",900)
        //Step2:透過insert()放入建立ContentValues至myTable新增資料
        dbrw.insert("myTable", null ,cv)

        //Step1:建立ContentValues物件，存放修改資料
        val cv = ContentValues()
        cv.put("price",800)
        //Step2:查詢book為百科全書的紀錄，透過update()修改資料
        dbrw.update("myTable", cv, "book='百科全書'", null)

        //查詢book為百科全書的紀錄
        dbrw.delete("myTable", "book='百科全書'", null)

        //查詢資料
        var number = ""
        var book = ""
        var price = ""
        //Step:建立要取得的欄位
        var column = arrayOf("book", "price")
        //Step2:透過query()查詢book為百科全書的紀錄，並儲存至Cursor
        val c = dbrw.query("myTable", column, "book='百科全書'",null,null,null,null)
        //判斷是否有資料
        if(c.count>0){
            //從第一筆開始輸出
            c.moveToFirst()
            //Step3:用迴圈將Cursor內的資料取出
            for(i in 0 until c.count){
                number += "$i\n"
                //取得book欄位的資料
                book += "${c.getString(0)}\n"
                //取得price欄位的資料
                price+= "${c.getString(1)}\n"
                //移至下一筆
                c.moveToNext()
            }

        }
        //資料庫取出後關閉Cursor
        c.close()
    }
}