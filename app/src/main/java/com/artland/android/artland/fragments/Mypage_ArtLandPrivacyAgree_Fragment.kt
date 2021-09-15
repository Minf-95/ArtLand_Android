package com.artland.android.artland.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.artland.android.artland.databinding.FragmentMypageArtlandprivacyagreeBinding

class Mypage_ArtLandPrivacyAgree_Fragment : Fragment() {
    private val TAG:String = "Mypage_ArtLandPrivachA_Fragment"
    private var mBinding : FragmentMypageArtlandprivacyagreeBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMypageArtlandprivacyagreeBinding.inflate(inflater, container, false)
        mBinding = binding


        return mBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding!!.imageViewMypageArtlandPrivacyAgreeClose.setOnClickListener {
            Log.d(TAG + " imageViewMypageArtlandTermOfUseClose", " 클릭")

        }


    }


}