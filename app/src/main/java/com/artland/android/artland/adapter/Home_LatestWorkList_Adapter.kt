package com.artland.android.artland.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artland.android.artland.R
import com.artland.android.artland.model.Home_LatestWorkLIst_Model

class Home_LatestWorkList_Adapter (var itemDataset:ArrayList<Home_LatestWorkLIst_Model>, var mContext: Context):
    RecyclerView.Adapter<Home_LatestWorkList_Adapter.customViewHolder>() {

    val TAG ="Home_RecommendGallery_Adapter"


    class customViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView_homeLatestWorkList_workTitle = itemView.findViewById<TextView>(R.id.textView_homeLatestWorkList_workTitle)
        val textView_homeLatestWorkList_workOwner = itemView.findViewById<TextView>(R.id.textView_homeLatestWorkList_workOwner)
        val textView_homeLatestWorkList_workPrice = itemView.findViewById<TextView>(R.id.textView_homeLatestWorkList_workPrice)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Home_LatestWorkList_Adapter.customViewHolder {
        Log.d(TAG,"onCreateViewHolder 들어옴")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_latestworklist,parent,false)
        return Home_LatestWorkList_Adapter.customViewHolder(view)    }


    //리스트의 개수
    override fun getItemCount(): Int {
        return itemDataset.size
    }

    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        holder.textView_homeLatestWorkList_workTitle.setText(itemDataset.get(position).workTitle)
        holder.textView_homeLatestWorkList_workOwner.setText(itemDataset.get(position).workOwner)
        holder.textView_homeLatestWorkList_workPrice.setText(itemDataset.get(position).workPrice.toString())
    }

}