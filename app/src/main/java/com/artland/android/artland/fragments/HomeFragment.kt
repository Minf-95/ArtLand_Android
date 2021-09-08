package com.artland.android.artland.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.artland.android.artland.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var mBinding : FragmentHomeBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.
    //이게 ViewBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        var binding = FragmentHomeBinding.inflate(inflater, container,false)
        mBinding = binding

        return mBinding?.root

    }


    //
    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()//프래그먼트 뷰가 살아질 때 메모리에서 제외가 되는데 그 전에 mbinding도 null
    }
}