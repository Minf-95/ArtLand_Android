package com.artland.android.artland.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.artland.android.artland.R
import com.artland.android.artland.adapter.Mypage_MyCollection_Adapter
import com.artland.android.artland.adapter.Mypage_MyWorkList_Adapter
import com.artland.android.artland.adapter.Mypage_TransactionHistory_Adapter
import com.artland.android.artland.databinding.FragmentMypageTransactionhistoryBinding
import com.artland.android.artland.model.Mypage_MyCollection_Model
import com.artland.android.artland.model.Mypage_MyWorkList_Model
import com.artland.android.artland.model.Mypage_TransactionHistoryAllContent_Model
import com.artland.android.artland.model.Mypage_TransactionHistoryAll_Model
import com.google.android.material.tabs.TabLayout
class Mypage_TransactionHistory_Fragment : Fragment() {


    private val TAG:String = "Mypage_TransactionHistory_Fragment"
    private var mBinding : FragmentMypageTransactionhistoryBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.

    private lateinit var transactionHistoryAllFragment:Mypage_TransactionHistory_All_Fragment // 전체 내역을 보여주는 프레그먼트
    private lateinit var transactionHistoryBuyFragment:MyPage_TransactionHistory_Buy_Fragment // 구매 내역을 보여주는 프레그먼트
    private lateinit var transactionHistorySellFragment:MyPage_TransactionHistory_Sell_Fragment // 판매 내역을 보여주는 프레그먼트

    //Framgment에 필요한 DataModel
    private var itemTransactionHistoryDataSetAll = arrayListOf<Mypage_TransactionHistoryAll_Model>()
    private var itemTransactionHistoryContentDataSetAll = arrayListOf<Mypage_TransactionHistoryAllContent_Model>() // 날짜에 대한 거래내역 내용 데이터


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
    //View
        var binding = FragmentMypageTransactionhistoryBinding.inflate(inflater, container, false)
        mBinding = binding


        //프레그먼트 객체화
        transactionHistoryAllFragment =Mypage_TransactionHistory_All_Fragment()
        transactionHistoryBuyFragment =MyPage_TransactionHistory_Buy_Fragment()
        transactionHistorySellFragment =MyPage_TransactionHistory_Sell_Fragment()


        //FrameLayout에서 첫 화면 설정 (transactionHistoryAllFragment)
        val fragmentManager: FragmentManager = childFragmentManager
        fragmentManager.beginTransaction().add(R.id.frameLayout_myPageTransactionHistory_view,transactionHistoryAllFragment).commit()

    //View

    //Controller
        getTransactionHistory()
    //Controller


        return mBinding?.root
    }//onCreate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding!!.imageViewMyPageTransactionHistoryBackBtn.setOnClickListener {
        Log.d(TAG + " imageViewMypageArtlandTermOfUseClose", " 클릭")
            findNavController().navigate(R.id.action_mypage_TransactionHistory_Fragment_to_mypageFragment)
        }

        
        //전체, 구매, 판매에 해당하는 Fragment로 이동
        mBinding!!.tabLayoutMyPageTransactionHistory.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            } override fun onTabUnselected(tab: TabLayout.Tab?) {

            } override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> {replaceView(transactionHistoryAllFragment)}
                    1 -> {replaceView(transactionHistoryBuyFragment)}
                    2 -> {replaceView(transactionHistorySellFragment)}
                }
            }
        })
    } //onViewCreated





    //프래그먼트 상태가 바뀔 때마다 호출
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        //프래그먼트 하이드 상태일때 동작
        if(isHidden) {
            Log.d("Log", "isHidden: $isHidden")
        }
        Log.d("Log", "onHiddenChanged")
    }


    private fun replaceView(tab:Fragment){
        //화면 변경
        var selectedFragment:Fragment? = null
        selectedFragment = tab
        selectedFragment?.let {
            val fragmentManager: FragmentManager = childFragmentManager
            fragmentManager.beginTransaction().replace(R.id.frameLayout_myPageTransactionHistory_view,it).commit()
            fragmentManager.popBackStack()

        }
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()//프래그먼트 뷰가 살아질 때 메모리에서 제외가 되는데 그 전에 mbinding도 null
    }

    private fun getTransactionHistory()
    {
        /*
        서버로부터 거래내역을 가지고 오는 메소드
         */
        var historyContent = Mypage_TransactionHistoryAllContent_Model("18:03:17"
                ,"김서판서"
                ,"dkfjsn3w1vlslkvjsndvl"
                ,"구매"
                ,0.12223)
        itemTransactionHistoryContentDataSetAll.add(historyContent)
        var addCountValueList = Mypage_TransactionHistoryAll_Model("2021.9.5",itemTransactionHistoryContentDataSetAll)
        itemTransactionHistoryDataSetAll.add(addCountValueList)


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
    }
}


