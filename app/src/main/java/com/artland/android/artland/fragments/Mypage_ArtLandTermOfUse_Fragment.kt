package com.artland.android.artland.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.artland.android.artland.R
import com.artland.android.artland.databinding.FragmentMypageArtlandtermofuseBinding


class Mypage_ArtLandTermOfUse_Fragment : Fragment() {
    private val TAG:String = "Mypage_ArtLandTermOfUse_Fragment"
    private var mBinding : FragmentMypageArtlandtermofuseBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMypageArtlandtermofuseBinding.inflate(inflater, container, false)
        mBinding = binding


        return mBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding!!.imageViewMypageArtlandTermOfUseClose.setOnClickListener {
            Log.d(TAG + " imageViewMypageArtlandTermOfUseClose", " 클릭")

//            val fragmentManager: FragmentManager = parentFragmentManager
//            fragmentManager.beginTransaction().remove(this@Mypage_ArtLandTermOfUse_Fragment).commit()
//            fragmentManager.popBackStack()
        }
    }


}