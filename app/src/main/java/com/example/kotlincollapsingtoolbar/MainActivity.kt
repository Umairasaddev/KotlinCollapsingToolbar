package com.example.kotlincollapsingtoolbar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlincollapsingtoolbar.ViewModel.MainViewModel
import com.example.kotlincollapsingtoolbar.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2
    lateinit var adapter: ViewPagerAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.view_pager)

        adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        tabLayout.addTab(tabLayout.newTab().setText("First"))
        tabLayout.addTab(tabLayout.newTab().setText("Second"))

        viewPager.adapter = adapter


        tabLayout.getTabAt(0)?.select()
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                if (tab != null) {
                    tab.view.background = ColorDrawable(Color.parseColor("#2571AD"))
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

                if (tab != null) {
                    tab.view.background = ColorDrawable(Color.parseColor("#4CAF50"))
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

    }
}









