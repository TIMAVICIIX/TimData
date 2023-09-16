package com.example.stardrawing.mainview.center

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stardrawing.R

class CenterRecycleAdapter(private val context: Context,private val recommendWorkList: List<RecommendWork>) :
    RecyclerView.Adapter<CenterRecycleAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val centerViewCover: ImageView = view.findViewById(R.id.recommend_Cover)
        val recommendText: TextView = view.findViewById(R.id.recommend_text)
        val recommendRewordImage: ImageView = view.findViewById(R.id.reword_View)
        val recommendRewordText: TextView = view.findViewById(R.id.reword_TextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.center_view_recommend_recycle_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recommendWork = recommendWorkList[position]

        holder.recommendText.text =
            "标题:${recommendWork.title}\n热度:${recommendWork.praise}\n类型:${recommendWork.Type}"

        Glide.with(context).load(recommendWork.coverId).into(holder.centerViewCover)

        imageTakeFun(position, holder)

    }

    override fun getItemCount(): Int = recommendWorkList.size

    private fun imageTakeFun(position: Int, holder: ViewHolder) {

        if (position < 3) {

            when (position) {


                0 -> Glide.with(context).load(R.drawable.recommend_praise_champion)
                    .into(holder.recommendRewordImage)

                1 -> Glide.with(context).load(R.drawable.recommend_praise_second)
                    .into(holder.recommendRewordImage)

                2 -> Glide.with(context).load(R.drawable.recommend_praise_third)
                    .into(holder.recommendRewordImage)
            }

            holder.recommendRewordText.text=""
        }else{

            holder.recommendRewordText.text="No.${position+1}"
            Glide.with(context).load(R.drawable.main_view_centerbtn_background)
                .into(holder.recommendRewordImage)

        }

    }

}