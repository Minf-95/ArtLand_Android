package com.artland.android.artland.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.artland.android.artland.DetailWorkActivity
import com.artland.android.artland.R
import com.artland.android.artland.model.Mypage_MyWorkList_Model

class Mypage_MyWorkList_Adapter  (val itemDataset:ArrayList<Mypage_MyWorkList_Model>, val mContext: Context): RecyclerView.Adapter<Mypage_MyWorkList_Adapter.customViewHolder>(){
    val TAG = "Mypage_MyCollection_Adapter"

    class customViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //View
        val itemMyWork = itemView.findViewById<ImageView>(R.id.imageView_myPageMyWorkList_work) // 텍스트 뷰 연결
        //View
        
        init{
            itemView.setOnClickListener { 
                //리사이클러뷰 아이템을 클릭했을때 실행되는 코드
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        Log.d(TAG,"onCreateViewHolder 들어옴")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mypage_myworklist,parent,false)
        return Mypage_MyWorkList_Adapter.customViewHolder(view)
    }



    //값을 넣어주는 곳
    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder 들어옴"+itemDataset.size)
        holder.itemMyWork.setImageResource(R.drawable.pic4)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailWorkActivity::class.java)
            intent.putExtra("content","원하는 데이터를 보냅니다.")
            intent.putExtra("no",11)
            ContextCompat.startActivity(holder.itemView.context, intent,null)
        }


        
    }


    //리스트의 개수
    override fun getItemCount(): Int {
        return itemDataset.size
    }


    //아이템 추가 함수
    fun addItem(itemData: Mypage_MyWorkList_Model){
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