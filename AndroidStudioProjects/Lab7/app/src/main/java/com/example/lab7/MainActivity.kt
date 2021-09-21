package com.example.lab7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //將變數與XML元件綁定
        val spinner = findViewById<Spinner>(R.id.spinner)
        val gridView = findViewById<GridView>(R.id.gridView)
        val listView = findViewById<ListView>(R.id.listView)

        //儲存購買數量資料
        val count = ArrayList<String>()
        //儲存菜資訊
        val item = ArrayList<Item>()
        //建立價格範圍
        val priceRange = IntRange(10,100)
        //從R類別讀取圖檔
        val array = resources.obtainTypedArray(R.array.image_list)
        for(i in 0 until array.length()){
            //料理圖片ID
            val photo = array.getResourceId(i,0)
            //料理名稱
            val name = "菜${i+1}"
            //亂數產生料理價
            val price = priceRange.random()
            //新增可購買數量資訊
            count.add("${i+1}個")
            //新增料理資訊
            item.add(Item(photo, name, price))
        }
        //釋放圖檔資源
        array.recycle()
        //建立ArrayAdapter物件，並傳入字串與simple_list_item_1.xml
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, count)
        //指定橫向顯示列數
        gridView.numColumns = 3
        //建立MyAdapter物件，並傳入adapter_vertical作為畫面
        gridView.adapter = MyAdapter(this, item, R.layout.adapter_vertical)
        //建立MyAdapter物件，並傳入adapter_horizontal作為畫面
        gridView.adapter = MyAdapter(this, item, R.layout.adapter_horizontal)
    }

}
//建立新類別定義菜的資料結構
data class Item(
    val photo: Int, //圖片
    val name: String, //名稱
    val price: Int //價格
)