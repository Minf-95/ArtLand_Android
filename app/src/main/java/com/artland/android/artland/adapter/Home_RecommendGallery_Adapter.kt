package com.artland.android.artland.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artland.android.artland.R
import com.artland.android.artland.model.Home_RecommendGallery_Model

class Home_RecommendGallery_Adapter (var itemDataset:ArrayList<Home_RecommendGallery_Model>,var mContext: Context):
    RecyclerView.Adapter<Home_RecommendGallery_Adapter.customViewHolder>() {

    val TAG ="Home_RecommendGallery_Adapter"


    class customViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView_homeRecommendGallery_currentParticipants = itemView.findViewById<TextView>(R.id.textView_homeRecommendGallery_currentParticipants)
        val textView_homeRecommendGallery_totalParticipants = itemView.findViewById<TextView>(R.id.textView_homeRecommendGallery_totalParticipants)
        val textView_homeRecommendGallery_workTitle = itemView.findViewById<TextView>(R.id.textView_homeRecommendGallery_workTitle)
        val textView_homeRecommendGallery_workOwner = itemView.findViewById<TextView>(R.id.textView_homeRecommendGallery_workOwner)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Home_RecommendGallery_Adapter.customViewHolder {
        Log.d(TAG,"onCreateViewHolder 들어옴")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_recommendgallery,parent,false)
        return Home_RecommendGallery_Adapter.customViewHolder(view)    }

    override fun onBindViewHolder(
        holder: Home_RecommendGallery_Adapter.customViewHolder,
        position: Int) {

        holder.textView_homeRecommendGallery_currentParticipants.setText(itemDataset.get(position).currentParticipants.toString())
        holder.textView_homeRecommendGallery_totalParticipants.setText(itemDataset.get(position).totalParticipants.toString())
        holder.textView_homeRecommendGallery_workTitle.setText(itemDataset.get(position).workTitle)
        holder.textView_homeRecommendGallery_workOwner.setText(itemDataset.get(position).workOwner)
    }

    //리스트의 개수
    override fun getItemCount(): Int {
        return itemDataset.size
    }


}