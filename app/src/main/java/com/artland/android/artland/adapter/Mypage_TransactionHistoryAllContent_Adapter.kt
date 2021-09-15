package com.artland.android.artland.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artland.android.artland.R
import com.artland.android.artland.model.Mypage_TransactionHistoryAllContent_Model

class Mypage_TransactionHistoryAllContent_Adapter(val itemDataset: ArrayList<Mypage_TransactionHistoryAllContent_Model>, val mContext: Context)
    : RecyclerView.Adapter<Mypage_TransactionHistoryAllContent_Adapter.customViewHolder>(){
    val TAG = "Mypage_TransactionHistoryAllContent_Adapter"

    class customViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contentDate = itemView.findViewById<TextView>(R.id.textView_myPageTransactionHistoryAllContent_date) // 텍스트 뷰 연결
        val contentNickName = itemView.findViewById<TextView>(R.id.textView_myPageTransactionHistoryAllContent_nickName) // 텍스트 뷰 연결
        val contentNftTokenValue = itemView.findViewById<TextView>(R.id.textView_myPageTransactionHistoryAllContent_nftTokenValue) // 텍스트 뷰 연결
        val contentStatus = itemView.findViewById<TextView>(R.id.textView_myPageTransactionHistoryAllContent_status) // 텍스트 뷰 연결
        val contentKlayValue = itemView.findViewById<TextView>(R.id.textView_myPageTransactionHistoryAllContent_contentKlayValue) // 텍스트 뷰 연결
        val bottomBorderLine = itemView.findViewById<View>(R.id.view_myPageTransactionHistoryAllContent_bottomBorder) // 텍스트 뷰 연결


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        Log.d(TAG,"onCreateViewHolder 들어옴")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mypage_transactionhistory_all_content,parent,false)
        return Mypage_TransactionHistoryAllContent_Adapter.customViewHolder(view)
    }



    //값을 넣어주는 곳
    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder 들어옴"+itemDataset.size)
        Log.d(TAG+ "position==itemDataset.size", position.toString())

        holder.contentDate.setText(itemDataset.get(position).contentDate)
        holder.contentNickName.setText(itemDataset.get(position).contentNickName)
        holder.contentNftTokenValue.setText(itemDataset.get(position).contentKlayToken)
        holder.contentStatus.setText(itemDataset.get(position).contentStatus)
        holder.contentKlayValue.setText((itemDataset.get(position).contentKlayValue).toString()+ " Klay")

        if(itemDataset.get(position).contentStatus =="판매"){
            /*
            Status가
            "판매" -> 파란색
            "구매" -> 빨간색
             */
            holder.contentStatus.setTextColor(Color.parseColor("#3D4EFE"))
            holder.contentKlayValue.setTextColor(Color.parseColor("#3D4EFE"))
        }else{
            holder.contentStatus.setTextColor(Color.parseColor("#F60000"))
            holder.contentKlayValue.setTextColor(Color.parseColor("#F60000"))
        }// if(itemDataset.get(position).contentStatus =="판매")


        if(itemDataset.size-1 == position){
            /*
            마지막 아이템은 하단 경계 라인을 숨겨준다.
             */
            Log.d(TAG+ "temDataset.size-1 == position","들어옴")
            Log.d(TAG+ "position==itemDataset.size", itemDataset.size.toString())

            holder.bottomBorderLine.visibility=View.GONE

        }// if(position==itemDataset.size)
    }


    //리스트의 개수
    override fun getItemCount(): Int {
        return itemDataset.size
    }


    //아이템 추가 함수
    fun addItem(itemData: Mypage_TransactionHistoryAllContent_Model){
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