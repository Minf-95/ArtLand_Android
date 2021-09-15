package com.artland.android.artland
import android.widget.Toast
import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.artland.android.artland.databinding.ActivityDetailWorkBinding
import com.artland.android.artland.databinding.ActivityInitSetAvartarBinding
import com.artland.android.artland.databinding.ActivityMainBinding
import com.artland.android.artland.fragments.DetailWork_WorkInformation_Fragment
import com.artland.android.artland.fragments.Mypage_MyCollectionList_Fragment
import com.artland.android.artland.fragments.Mypage_MyWorkList_Fragment
import com.artland.android.artland.model.Mypage_TransactionHistoryAll_Model

class DetailWorkActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityDetailWorkBinding
    private lateinit var detailWorkWorkInformationFragment:DetailWork_WorkInformation_Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityDetailWorkBinding.inflate(layoutInflater)
        setContentView(mbinding.root)

        //프래그먼트 객체화
        detailWorkWorkInformationFragment = DetailWork_WorkInformation_Fragment()


        //TabLayout과 연동되어있는 FrameLayout 첫 화면 설정
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout_detailWork_view, detailWorkWorkInformationFragment).commit();

        getWorkInformation()

        mbinding!!.imageViewDetailWorkClose.bringToFront()

        mbinding!!.imageViewDetailWorkClose.setOnClickListener {
            finish()
        }
    }

    private fun getWorkInformation(){

        val getIntent = intent.getStringExtra("content")
        Toast.makeText(getApplicationContext(),getIntent,Toast.LENGTH_LONG).show()
    }
}