package com.example.testrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var mDataSet: MutableList<Pair<String,String>>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    interface OnItemClickListener {

        fun onItemClick(view: View, position:Int)

    }

    inner class MyViewHolder(var textView: TextView) : RecyclerView.ViewHolder(textView),View.OnClickListener{

        init {
            this.textView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onItemClickListener.onItemClick(v!!,layoutPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        val vh = MyViewHolder(v)
        return vh
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = mDataSet[position].first
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }


}