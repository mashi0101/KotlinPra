package com.example.lab15

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//自定建構子並繼承SQLiteOpenHelper
class MyDBHelper(
    context: Context,
    name: String = database,
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = v
) : SQLiteOpenHelper(context,name,factory,version){
    companion object{
        //資料庫名稱
        private const val database = "myDatabase"
        //資料庫版本
        private const val v = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        //這裡寫要加入建立資料表的SQL語法
        db.execSQL("CREATE TABLE myTable(book TEXT PRIMARY KEY, price INTEGER NOT NULL)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //這裡寫要升級資料庫版本的SQL語法
        //當表已存在將其刪除
        db.execSQL("DROP TABLE IF EXISTS myTable")
        //刪除資料表後重新呼叫onCreate()方法建立新的資料表
        onCreate(db)
    }
}