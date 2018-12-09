package com.example.caikai.recyclerviewsource

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caikai.recyclerviewsource.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        val data = HashMap<String, Any>()

    }

    init {
        data["LayoutManager"] = MainActivity::javaClass
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }

    inner class MainAdapter() : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(applicationContext).inflate(R.layout.item_main, p0, false))
        }

        override fun getItemCount(): Int {
            return 0
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        }
    }
}
