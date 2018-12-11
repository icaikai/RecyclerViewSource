package com.example.caikai.recyclerviewsource

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.caikai.recyclerviewsource.databinding.ActivityMainBinding
import com.example.caikai.recyclerviewsource.layoutmanager.LayoutManagerActivity

class MainActivity : AppCompatActivity() {

    val data = arrayOf(
            Demo("LayoutManager",LayoutManagerActivity::class.java)
    )


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        with(binding.recyclerView){
            layoutManager = LinearLayoutManager(context)
            adapter = MainAdapter()
        }

    }

    data class Demo(val title:String,val clz:Class<*>){}


    inner class MainAdapter() : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(applicationContext).inflate(R.layout.item_main, p0, false))
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            p0.tvTitle.text = data[p1].title
            p0.itemView.setOnClickListener {
                startActivity(Intent().apply {
                    setClass(applicationContext,this@MainActivity.data[p1].clz)
                })
            }
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvTitle:TextView = itemView.findViewById(R.id.tv_title)

        }
    }
}
