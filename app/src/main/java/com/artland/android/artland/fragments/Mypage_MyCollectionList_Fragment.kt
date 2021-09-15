package com.artland.android.artland.fragments

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.artland.android.artland.adapter.Mypage_MyCollection_Adapter
import com.artland.android.artland.databinding.FragmentMypageMycollectionlistBinding
import com.artland.android.artland.model.Mypage_MyCollection_Model
import java.util.*


class Mypage_MyCollectionList_Fragment  : Fragment() {
    private val TAG:String = "Mypage_ArtLandPrivachAgree_Fragment"
    private var mBinding : FragmentMypageMycollectionlistBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.


    private var itemMyCollectionDataset = arrayListOf<Mypage_MyCollection_Model>()
    private lateinit var adapterMycollection:Mypage_MyCollection_Adapter


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMypageMycollectionlistBinding.inflate(inflater, container, false)
        mBinding = binding







        //View
        adapterMycollection = Mypage_MyCollection_Adapter(itemMyCollectionDataset, requireContext())
        mBinding!!.recyclerViewMyPageContainer.adapter=adapterMycollection
        val gridLayoutManager=GridLayoutManager(requireContext(),3)
        mBinding!!.recyclerViewMyPageContainer.layoutManager=gridLayoutManager
        //View




        //Controller
        for(countValue in 1..3 step 1 ){
            var addCountValueList = Mypage_MyCollection_Model(countValue)
            itemMyCollectionDataset.add(addCountValueList)
        }
        adapterMycollection.notifyDataSetChanged()
        //Controller

        return mBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}