package com.example.testrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var recycleView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private lateinit var layoutManager: LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        recycleView = findViewById(R.id.my_recycler_view)
        recycleView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        recycleView.layoutManager = layoutManager

        val countries = mutableListOf<Pair<String, String>>().apply {
            add(
                Pair(
                    "Android简介",
                    "1.Android的发展简介\n2.Android的系统架构\n3.Android的版本简介\n4.Android的开发环境搭建"
                )
            )
            add(Pair("Android应用界面", "1.布局管理器\n2.UI组件3.高级组件\n4.本章总结\n5.课后习题"))
            add(Pair("Activity", "1.Activity的创建\n2.Activity的启动\n3.Intent和Intent过滤器"))
            add(
                Pair(
                    "数据存储",
                    "1.共享首选项\n2.使用内部存储\n3.使用外部存储\n4.使用数据库\n5.本章总结"
                )
            )
        }

        myAdapter = MyAdapter(countries)

        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {

                val infoIntent = Intent(this@MainActivity, SecondActivity::class.java)

                val infoBundle = Bundle().apply {
                    putString("title", countries[position].first)
                    putString("content", countries[position].second)
                }

                infoIntent.putExtra("info", infoBundle)
                startActivity(infoIntent, infoBundle)

            }
        })

        recycleView.adapter = myAdapter

    }

}