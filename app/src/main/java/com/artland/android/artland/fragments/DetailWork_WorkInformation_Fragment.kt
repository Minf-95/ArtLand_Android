package com.artland.android.artland.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.artland.android.artland.databinding.FragmentDetailworkWorkinformationBinding
import com.artland.android.artland.databinding.FragmentMypageArtlandversioninformationBinding

class DetailWork_WorkInformation_Fragment  : Fragment() {
    private val TAG:String = "Mypage_ArtLandVersionInformation_Fragment"
    private var mBinding : FragmentDetailworkWorkinformationBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentDetailworkWorkinformationBinding.inflate(inflater, container, false)
        mBinding = binding


        return mBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}