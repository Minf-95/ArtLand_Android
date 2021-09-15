package com.artland.android.artland.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.artland.android.artland.R
import com.artland.android.artland.databinding.FragmentMypageArtlandtermofuseBinding
import com.artland.android.artland.databinding.FragmentMypageArtlandversioninformationBinding

class Mypage_ArtLandVersionInformation_Fragment : Fragment() {
    private val TAG:String = "Mypage_ArtLandVersionInformation_Fragment"
    private var mBinding : FragmentMypageArtlandversioninformationBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMypageArtlandversioninformationBinding.inflate(inflater, container, false)
        mBinding = binding


        return mBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding!!.linearLayoutArtLandVersionInformationCloseContainer.setOnClickListener {
            Log.d(TAG + " linearLayoutArtLandVersionInformationCloseContainer", " 클릭")

//            val fragmentManager: FragmentManager = parentFragmentManager
//            fragmentManager.beginTransaction().remove(this@Mypage_ArtLandTermOfUse_Fragment).commit()
//            fragmentManager.popBackStack()
        }
    }


}