package com.example.lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MainActivity","onCreate")
        //建立FragmentPagerAdapter物件
        val adapter = ViewPagerAdapter(supportFragmentManager)
        //連結adapter讓Fragment畫面與ViewPager建立關聯
        findViewById<ViewPager>(R.id.viewPager).adapter = adapter

        findViewById<Button>(R.id.btn).setOnClickListener{
            val intent = Intent(this, CallByMain::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("MainActivity","onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("MainActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("MainActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("MainActivity","onDestroy")
    }

}
//建立class ViewPagerAdapter 繼承 FragmentPagerAdapter
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    //回傳對應位置的Fragment，決定頁面的呈現順序
    override fun getItem(position: Int) =  when(position) {
        0 -> FirstFragment()
        1 -> SecondFragment()
        else -> ThirdFragment()
    }
    //回傳Fragment頁數
    override fun getCount()=3
}


