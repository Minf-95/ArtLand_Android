package com.artland.android.artland.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.artland.android.artland.adapter.Home_LatestWorkList_Adapter
import com.artland.android.artland.adapter.Home_RecommendGallery_Adapter
import com.artland.android.artland.databinding.FragmentHomeBinding
import com.artland.android.artland.model.Home_LatestWorkLIst_Model
import com.artland.android.artland.model.Home_RecommendGallery_Model

class HomeFragment : Fragment() {

    //ViewBinding
    private var mBinding : FragmentHomeBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.




    //RecyclerView에 필요한 Adapter
    private lateinit var adapterHomeRecommendGallery: Home_RecommendGallery_Adapter //추천 갤러리 어댑터
    private lateinit var adapterHomeLatestWorkList: Home_LatestWorkList_Adapter //최신 작품 리스트 어댑터


    //RecyclerView에 필요한 DataModel
    private var homeRecommendGalleryDataSet = arrayListOf<Home_RecommendGallery_Model>()
    private var homeLatestWorkListDataSet = arrayListOf<Home_LatestWorkLIst_Model>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

     //View
        var binding = FragmentHomeBinding.inflate(inflater, container,false)
        mBinding = binding

        //추천 갤러리 RecyclerView와 Adapter 연결
        adapterHomeRecommendGallery = Home_RecommendGallery_Adapter(homeRecommendGalleryDataSet, requireContext())
        mBinding!!.recyclerViewHomeRecommanedGallery.adapter=adapterHomeRecommendGallery

        adapterHomeLatestWorkList = Home_LatestWorkList_Adapter(homeLatestWorkListDataSet, requireContext())
        mBinding!!.recyclerViewHomeLatestWorkList.adapter=adapterHomeLatestWorkList
        //최신 작품 리스트 RecyclerView 와 Adatper
     //View




    //Controller
        getRecommendGallery() //추천 갤러리 정보 가지고오기
        getLatestWorkList() //최신 작품 리스트 정보 가지고오기
    //Controller
        return mBinding?.root

    }

 

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()//프래그먼트 뷰가 살아질 때 메모리에서 제외가 되는데 그 전에 mbinding도 null
    }


    private fun getRecommendGallery()
    {
        /*
        서버로부터 추천 갤러리 정보를 가지고 오는 메소드
         */

        for(countValue in 1..3 step 1 ){
            var historyContent = Home_RecommendGallery_Model(1
                ,2
                ,12
                ,"서울 걷다"
                ,"홍길동")
            homeRecommendGalleryDataSet.add(historyContent)
        }
        adapterHomeRecommendGallery.notifyDataSetChanged()
    }

    private fun getLatestWorkList() 
    {
        /*
        서버로부터 최신 작품 리스트 정보를 가지고 오는 메소드
         */
        for(countValue in 1..3 step 1 ){
            var historyContent = Home_LatestWorkLIst_Model(1
                ,"낙원"
                ,"홍길동"
                ,2.165)
            homeLatestWorkListDataSet.add(historyContent)
        }
        adapterHomeRecommendGallery.notifyDataSetChanged()
    }
}