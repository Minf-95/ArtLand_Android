package com.artland.android.artland.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.artland.android.artland.R
import com.artland.android.artland.adapter.Mypage_TransactionHistory_Adapter
import com.artland.android.artland.databinding.FragmentMypageTransactionhistoryBuyBinding
import com.artland.android.artland.databinding.FragmentMypageTransactionhistorySellBinding
import com.artland.android.artland.model.Mypage_TransactionHistoryAllContent_Model
import com.artland.android.artland.model.Mypage_TransactionHistoryAll_Model

class MyPage_TransactionHistory_Sell_Fragment  : Fragment() {
    /*
    중첩 리사이클러뷰에 대한 프래그먼트
    - 날짜에 대한 리사이클러뷰 (현재 프래그먼트)
      - 해당 날짜의 내용에 대한 리사이클러뷰
     */
    private val TAG:String = "Mypage_TransactionHistory_Sell_Fragment"
    private var mBinding : FragmentMypageTransactionhistorySellBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.

    //Framgment에 필요한 DataModel
    private var itemTransactionHistoryDataSetAll = arrayListOf<Mypage_TransactionHistoryAll_Model>()
    private var itemTransactionHistoryContentDataSetAll = arrayListOf<Mypage_TransactionHistoryAllContent_Model>() // 날짜에 대한 거래내역 내용 데이터

    //RecyclerView에 필요한 Adapter
    private lateinit var adapterTransactionHistoryAll: Mypage_TransactionHistory_Adapter

    //클릭 된 조회 날짜 포지션 값
    private var checkClickedViewPosition:Int =1

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMypageTransactionhistorySellBinding.inflate(inflater, container, false)
        mBinding = binding



        //View
        //RecyclerView와 Adapter 연결
        adapterTransactionHistoryAll = Mypage_TransactionHistory_Adapter(itemTransactionHistoryDataSetAll, requireContext())
        mBinding!!.recyclerViewMyPageTransactionHistoryHisotryDate.adapter=adapterTransactionHistoryAll
        //View




        //Controller
        clickInquireDate() //1주일, 1개월, 6개월, 상세조회 클릭리스너 메소드
        getTransactionHistory() //서버로부터 거래내역을 가지고 오는 메소드
        //Controller

        return mBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG + " imageViewMypageArtlandTermOfUseClose", " 클릭")

    }

    private fun getTransactionHistory()
    {
        /*
        서버로부터 거래내역을 가지고 오는 메소드
         */

//        var historyContent = Mypage_TransactionHistoryAllContent_Model("18:03:17"
//                ,"김서판서"
//                ,"dkfjsn3w1vlslkvjsndvl"
//                ,"구매"
//                ,0.12223)
//        itemTransactionHistoryContentDataSetAll.add(historyContent)
//        var addCountValueList = Mypage_TransactionHistoryAll_Model("2021.9.5",itemTransactionHistoryContentDataSetAll)
//        itemTransactionHistoryDataSetAll.add(addCountValueList)


        for(countValue in 1..3 step 1 ){
            var historyContent = Mypage_TransactionHistoryAllContent_Model("18:03:17"
                    ,"홍작가"
                    ,"dkfjsn3w1vlslkvjsndvl"
                    ,"판매"
                    ,0.12223)
            itemTransactionHistoryContentDataSetAll.add(historyContent)
            var addCountValueList = Mypage_TransactionHistoryAll_Model("2021.9.5",itemTransactionHistoryContentDataSetAll)
            itemTransactionHistoryDataSetAll.add(addCountValueList)
        }
        adapterTransactionHistoryAll.notifyDataSetChanged()
    }





    private fun clickInquireDate(){
        /*
       checkClickedViewPosition
       1주일 = 1
       1개월 = 2
       6개월 = 3
       상세조회 = 4

       클릭한 곳을 제외한 나머지는 NonClicked 색상 및 Background로 설정
         */
        mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setOnClickListener {
            mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setTextColor(Color.parseColor("#FFFFFF"))
            mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setBackgroundResource(R.drawable.nomal_btn_border)
            checkClickedViewPosition = 1
            clickedDate(checkClickedViewPosition)
        }
        mBinding!!.textViewMyPageTransactionHistoryAllMonth.setOnClickListener {
            mBinding!!.textViewMyPageTransactionHistoryAllMonth.setTextColor(Color.parseColor("#FFFFFF"))
            mBinding!!.textViewMyPageTransactionHistoryAllMonth.setBackgroundResource(R.drawable.nomal_btn_border)

            checkClickedViewPosition = 2
            clickedDate(checkClickedViewPosition)

        }
        mBinding!!.textViewMyPageTransactionHistoryAll6month.setOnClickListener {
            mBinding!!.textViewMyPageTransactionHistoryAll6month.setTextColor(Color.parseColor("#FFFFFF"))
            mBinding!!.textViewMyPageTransactionHistoryAll6month.setBackgroundResource(R.drawable.nomal_btn_border)

            checkClickedViewPosition = 3
            clickedDate(checkClickedViewPosition)

        }
        mBinding!!.textViewMyPageTransactionHistoryAllDetail.setOnClickListener {
            mBinding!!.textViewMyPageTransactionHistoryAllDetail.setTextColor(Color.parseColor("#FFFFFF"))
            mBinding!!.textViewMyPageTransactionHistoryAllDetail.setBackgroundResource(R.drawable.nomal_btn_border)

            checkClickedViewPosition = 4
            clickedDate(checkClickedViewPosition)

        }


    }


    private fun clickedDate(checkClickedViewPosition:Int){
        /*
        거래내역을
        1주일, 1개월 ,6개월, 상세조회
        로 조회할 수 있다.
         */
        if(checkClickedViewPosition ==1){
            mBinding!!.textViewMyPageTransactionHistoryAllMonth.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllMonth.setBackgroundResource(R.drawable.darkgray_button_border)

            mBinding!!.textViewMyPageTransactionHistoryAll6month.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAll6month.setBackgroundResource(R.drawable.darkgray_button_border)

            mBinding!!.textViewMyPageTransactionHistoryAllDetail.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllDetail.setBackgroundResource(R.drawable.darkgray_button_border)
        }else if(checkClickedViewPosition == 2){
            mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setBackgroundResource(R.drawable.darkgray_button_border)

            mBinding!!.textViewMyPageTransactionHistoryAll6month.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAll6month.setBackgroundResource(R.drawable.darkgray_button_border)

            mBinding!!.textViewMyPageTransactionHistoryAllDetail.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllDetail.setBackgroundResource(R.drawable.darkgray_button_border)


        }else if(checkClickedViewPosition == 3){
            mBinding!!.textViewMyPageTransactionHistoryAllMonth.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllMonth.setBackgroundResource(R.drawable.darkgray_button_border)

            mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setBackgroundResource(R.drawable.darkgray_button_border)

            mBinding!!.textViewMyPageTransactionHistoryAllDetail.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllDetail.setBackgroundResource(R.drawable.darkgray_button_border)

        }else if(checkClickedViewPosition == 4){
            mBinding!!.textViewMyPageTransactionHistoryAllMonth.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllMonth.setBackgroundResource(R.drawable.darkgray_button_border)

            mBinding!!.textViewMyPageTransactionHistoryAll6month.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAll6month.setBackgroundResource(R.drawable.darkgray_button_border)

            mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setTextColor(Color.parseColor("#000000"))
            mBinding!!.textViewMyPageTransactionHistoryAllWeeks.setBackgroundResource(R.drawable.darkgray_button_border)

        }
        mBinding!!.textViewMyPageTransactionHistoryAllWeeks
    }
}
