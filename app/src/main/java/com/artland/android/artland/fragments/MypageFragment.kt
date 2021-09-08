package com.artland.android.artland.fragments
import android.widget.Toast

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.artland.android.artland.LoginActivity
import com.artland.android.artland.databinding.FragmentMypageBinding
import com.example.example_kakaologin.customDialog.withdrawalCustomDialog
import com.kakao.sdk.user.UserApiClient


class MypageFragment:Fragment() {
    val TAG:String = "MypageFragment"

    private var mBinding : FragmentMypageBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.
    //이게 ViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = FragmentMypageBinding.inflate(inflater, container,false)
        mBinding = binding




        //Menu버튼을 누르면 설정 창이 나온다.
        mBinding!!.mypageMenuBtn.setOnClickListener {
            mBinding!!.mypageDrawer.openDrawer(GravityCompat.END)
        }

        //로그아웃을 누르면 로그아웃이 되면서 로그인 페이지로 이동된다.
        mBinding!!.mypageLogoutBtn.setOnClickListener {
            logout() //로그아웃
        }

        //회원탈퇴를 누르면 카카오와 연결이 끊어지게 되면서 로그인 페이지로 이동된다.
        mBinding!!.mypageWithdrwalBtn.setOnClickListener {
            showWithdrwalCustomDialog() //회원탈퇴
        }
        return mBinding?.root
    }



    /*
    logout() 메소드가 실행 되면서 로그아웃이 되고,
    로그인 화면으로 이동하게 된다.
    */
    fun logout() {
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Log.e(TAG, "로그아웃 실패. SDK에서 토큰 삭제됨", error)
            }
            else {
                Log.i(TAG, "로그아웃 성공. SDK에서 토큰 삭제됨")
            }
        }
        Toast.makeText(context,"로그아웃 되셨습니다.",Toast.LENGTH_LONG).show()
        val mIntent = Intent(context, LoginActivity::class.java)
        startActivity(mIntent)
    }


     //회원탈퇴 다이얼로그
     fun showWithdrwalCustomDialog(){
        Log.d(TAG+ " showWithdrwalCustomDialog","들어옴")
        val withdrwalDialog = withdrawalCustomDialog(context!!)
        withdrwalDialog.showWithdrwalDialog()
    }




    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()//프래그먼트 뷰가 살아질 때 메모리에서 제외가 되는데 그 전에 mbinding도 null
    }




}