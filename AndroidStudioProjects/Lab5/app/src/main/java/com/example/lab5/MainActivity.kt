package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //建立FragmentPagerAdapter物件
        val adapter = ViewPagerAdapter(supportFragmentManager)
        //連結adapter讓Fragment畫面與ViewPager建立關聯
        findViewById<ViewPager>(R.id.viewPager).adapter=adapter
    }
}
//建立class ViewPagerAdapter 繼承 FragmentPagerAdapter
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int) =  when(position) {
        0 -> FirstFragment()
        1 -> SecondFragment()
        else -> ThirdFragment()
    }

    override fun getCount()=3
    }
}