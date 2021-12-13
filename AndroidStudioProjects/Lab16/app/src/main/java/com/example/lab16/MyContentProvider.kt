package com.example.lab16

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class MyContentProvider : ContentProvider() {
    private lateinit var dbrw: SQLiteDatabase

    //Step1:當Resolver要求操作資料時，Provider會先進入onCreate()，需先開啟資料庫
    override fun onCreate(): Boolean {
        val context = context ?: return false
        //取得資料庫實體
        dbrw = MyDBHelper(context).writableDatabase
        return true
    }

    //Step2:Resolver要求新增資料，則取得它給予的資料並新增於資料庫
    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        //取出其他應用程式給予的book資料
        val book = values ?: return null
        //將資料薪曾於資料庫病回傳此筆紀錄的ID
        val rowID = dbrw.insert("myTable", null, book)
        //回傳此筆紀錄的Uri
        return Uri.parse("content://com.italkutalk.lab16/book/$rowID")
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int = 0

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int = 0

    override fun getType(uri: Uri): String? = null

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? = null

}