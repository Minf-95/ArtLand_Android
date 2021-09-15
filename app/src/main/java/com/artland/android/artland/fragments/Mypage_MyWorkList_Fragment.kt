package com.artland.android.artland.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.artland.android.artland.adapter.Mypage_MyCollection_Adapter
import com.artland.android.artland.adapter.Mypage_MyWorkList_Adapter
import com.artland.android.artland.databinding.FragmentMypageMyworklistBinding
import com.artland.android.artland.model.Mypage_MyCollection_Model
import com.artland.android.artland.model.Mypage_MyWorkList_Model

class Mypage_MyWorkList_Fragment   : Fragment() {
    private val TAG:String = "Mypage_ArtLandPrivachAgree_Fragment"
    private var mBinding : FragmentMypageMyworklistBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.


    private var itemMyWorkListDataset = arrayListOf<Mypage_MyWorkList_Model>()
    private lateinit var adapterMyWorkList: Mypage_MyWorkList_Adapter


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentMypageMyworklistBinding.inflate(inflater, container, false)
        mBinding = binding







        //View
        adapterMyWorkList = Mypage_MyWorkList_Adapter(itemMyWorkListDataset, requireContext())
        mBinding!!.recyclerViewMyPageMyWorkListContainer.adapter=adapterMyWorkList
        val gridLayoutManager= GridLayoutManager(requireContext(),3)
        mBinding!!.recyclerViewMyPageMyWorkListContainer.layoutManager=gridLayoutManager
        //View




        //Controller
        for(countValue in 1..3 step 1 ){
            var addCountValueList = Mypage_MyWorkList_Model(countValue,"흰색의 미","김작가","홍길동","abkdnvdjfkdk"
                    ," 가슴에 우리의 얼마나 하여도 이상을 것은 사막이다. 같지 실현에 하였으며, 이것이야말로 이상의 것은 얼마나 무엇을 부패뿐이다. 풍부하게 끓는 바이며, 끓는다. ")
            itemMyWorkListDataset.add(addCountValueList)
        }
        adapterMyWorkList.notifyDataSetChanged()
        //Controller

        return mBinding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}