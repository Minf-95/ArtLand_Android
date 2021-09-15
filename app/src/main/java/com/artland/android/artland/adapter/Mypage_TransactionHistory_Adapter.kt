package com.artland.android.artland.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artland.android.artland.R
import com.artland.android.artland.model.Mypage_MyWorkList_Model
import com.artland.android.artland.model.Mypage_TransactionHistoryAllContent_Model
import com.artland.android.artland.model.Mypage_TransactionHistoryAll_Model

class Mypage_TransactionHistory_Adapter (var itemDataset:ArrayList<Mypage_TransactionHistoryAll_Model>,
                                         mContext:Context): RecyclerView.Adapter<Mypage_TransactionHistory_Adapter.customViewHolder>(){
    /*
    중첩 리사이클러뷰에 대한 어뎁터 설정
    - 날짜에 대한 리사이클러뷰 (현재 어뎁터)
      - 해당 날짜의 내용에 대한 리사이클러뷰
     */

    val TAG = "Mypage_TransactionHistory_Adapter"
    val mContext = mContext

    class customViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textHistoryDate = itemView.findViewById<TextView>(R.id.textView_myPageTransactionHistoryAll_date) // 텍스트 뷰 연결
        val recyclerViewHistoryAllContent = itemView.findViewById<RecyclerView>(R.id.recyclerView_myPageTransactionHistoryAll_history) // 해당 날짜의 내용에 대한 리사이클러뷰
        val viewBottomLine = itemView.findViewById<View>(R.id.view_myPageTransactionHistoryAll_bottomBorder)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customViewHolder {
        Log.d(TAG,"onCreateViewHolder 들어옴")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mypage_transactionhisotry_all,parent,false)
        return Mypage_TransactionHistory_Adapter.customViewHolder(view)
    }



    //값을 넣어주는 곳
    override fun onBindViewHolder(holder: customViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder 들어옴"+itemDataset.size)

        //Content 리사이클러뷰 세팅
        val contentDataSet: ArrayList<Mypage_TransactionHistoryAllContent_Model> = itemDataset.get(position).contentDataset //날짜에 해당하는 내용을 가지고옴
        val itemListDataAdapter = Mypage_TransactionHistoryAllContent_Adapter(contentDataSet,mContext)//Content 어댑터 설정
        holder.recyclerViewHistoryAllContent.setHasFixedSize(true)
        holder.recyclerViewHistoryAllContent.adapter=itemListDataAdapter // 리사이클러뷰에 어뎁터 설정
        //Content 리사이클러뷰 세팅
        
        
        holder.textHistoryDate.setText(itemDataset.get(position).historyDate)


        if(itemDataset.size-1 == position){
            /*
            마지막 item이 오면 하단 경계 라인 보이기
             */
            holder.viewBottomLine.visibility=View.VISIBLE
        }


    }


    //리스트의 개수
    override fun getItemCount(): Int {
        return itemDataset.size
    }


    //아이템 추가 함수
    fun addItem(itemData: Mypage_TransactionHistoryAll_Model){
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