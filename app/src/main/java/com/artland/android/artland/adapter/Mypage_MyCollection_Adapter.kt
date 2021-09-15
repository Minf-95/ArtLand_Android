package com.artland.android.artland.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.artland.android.artland.R
import com.artland.android.artland.model.Mypage_MyCollection_Model

class Mypage_MyCollection_Adapter (val itemDataset:ArrayList<Mypage_MyCollection_Model>, val mContext: Context): RecyclerView.Adapter<Mypage_MyCollection_Adapter.customViewHolder>(){
    val TAG = "Mypage_MyCollection_Adapter"

    class customViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemMyWork = itemView.findViewById<ImageView>(R.id.imageView_myPageMyCollection_work) // 텍스트 뷰 연결
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        Log.d(TAG,"onCreateViewHolder 들어옴")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mypage_mycollection,parent,false)
        return Mypage_MyCollection_Adapter.customViewHolder(view)
    }



    //값을 넣어주는 곳
    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder 들어옴"+itemDataset.size)
        holder.itemMyWork.setImageResource(R.drawable.pic1)
    }


    //리스트의 개수
    override fun getItemCount(): Int {
        return itemDataset.size
    }


    //아이템 추가 함수
    fun addItem(itemData: Mypage_MyCollection_Model){
        itemDataset.add(itemData) // 데이터 리스트에 추가
        notifyDataSetChanged() // 추가 된 데이터 갱신하기
    }

    //아이템 제거 함수
    fun removeItem(position: Int){
        if(position>0){
            itemDataset.removeAt(position)
            notifyDataSetChanged()
        }
    }

}