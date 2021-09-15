package com.artland.android.artland.fragments

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.artland.android.artland.LoginActivity
import com.artland.android.artland.R
import com.artland.android.artland.databinding.FragmentMypageBinding
import com.example.example_kakaologin.customDialog.withdrawalCustomDialog
import com.google.android.material.tabs.TabLayout
import com.kakao.sdk.user.UserApiClient


class MypageFragment:Fragment() {
    val TAG:String = "MypageFragment"

    private var mBinding : FragmentMypageBinding? = null //이렇게 해주면 layout에 있는 fragment_home을 알아서 인식해서 클래스를 만들어준다.
    private lateinit var myCollectionListFragment:Mypage_MyCollectionList_Fragment
    private lateinit var myWorkListFragment:Mypage_MyWorkList_Fragment



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // 뷰를 만들 떄 실행할 내용이 들어간다.

        var binding = FragmentMypageBinding.inflate(inflater, container, false)
        mBinding = binding

        //프래그먼트 객체화
        myCollectionListFragment =Mypage_MyCollectionList_Fragment()
        myWorkListFragment = Mypage_MyWorkList_Fragment()

        //TabLayout과 연동되어있는 FrameLayout 첫 화면 설정
        val fragmentManager: FragmentManager = childFragmentManager
        fragmentManager.beginTransaction().add(R.id.frameLayout_myPage_view, myWorkListFragment).commit()






        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //뷰가 만들어지면 실행할 내용

        mBinding!!.mypageMenuBtn.setOnClickListener {
            mBinding!!.mypageDrawer.openDrawer(GravityCompat.END) //메뉴창이 나온다.
        }

        mBinding!!.mypageLogoutBtn.setOnClickListener {
            logout() //로그아웃
        }

        mBinding!!.mypageWithdrwalBtn.setOnClickListener {
            showWithdrwalCustomDialog() //회원탈퇴
        }

        mBinding!!.textViewMyPageTermOfUse.setOnClickListener {
            findNavController().navigate(R.id.action_mypageFragment_to_mypage_ArtLandTermOfUse_Fragment) //이용약관 프레그먼트로 이동
        }

        mBinding!!.textViewMyPagePrivachAgree.setOnClickListener {
            findNavController().navigate(R.id.action_mypageFragment_to_mypage_ArtLandPrivacyAgree_Fragment) //개인정보 수집 및 동의 프레그먼트 이동
        }

        mBinding!!.tabLayoutMyPageContainer.addTab(mBinding!!.tabLayoutMyPageContainer.newTab().setText("나의 작품 리스트 (11)"))
        mBinding!!.tabLayoutMyPageContainer.addTab(mBinding!!.tabLayoutMyPageContainer.newTab().setText("나의 컬렉션 리스트 (11)"))

        
        mBinding!!.linearLayoutMyPageTransactionHistoryContainer.setOnClickListener { 
            Log.d(TAG + " linearLayoutMyPageTransactionHistoryContainer", "클릭")
            findNavController().navigate(R.id.action_mypageFragment_to_mypage_TransactionHistory_Fragment) //거래내역 프레그먼트로 이동
        }

        mBinding!!.textViewMyPageArtLandVersionInformation.setOnClickListener {
            findNavController().navigate(R.id.action_mypageFragment_to_mypage_ArtLandVersionInformation_Fragment) // 버전 정보 프레그먼트로 이동
        }

        mBinding!!.textViewMyPageQuestion.setOnClickListener {
            sendToDevelopment() //개발자한테 이메일 보내기
        }
        //나의 작품 리스트, 나의 컬렉션 리스트 탭을 눌렀을 때 해당하는 Fragment로 이동
        mBinding!!.tabLayoutMyPageContainer.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab!!.position) {
                    0 -> replaceView(myWorkListFragment)  //나의 작품 리스트 프레레그먼트
                    1 -> replaceView(myCollectionListFragment) //나의 컬렉션 프레그먼트
                }
            }
        })
    }


    //프래그먼트 상태가 바뀔 때마다 호출
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        //프래그먼트 하이드 상태일때 동작
        if(isHidden) {
            Log.d("Log", "isHidden: $isHidden")
        }

        Log.d("Log", "onHiddenChanged")
    }

    private fun sendToDevelopment(){
        /*
        개발자에게 이메일을 보내게 해주는 메소드
         - 앱버전, 기기밍, OS, 내용
         */
            val emailSelectorIntent = Intent(Intent.ACTION_SENDTO)
            emailSelectorIntent.data = Uri.parse("mailto:")
            val address = arrayOf("artland0904@gmail.com")
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.putExtra(Intent.EXTRA_EMAIL, address)
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "<아트랜드 문의사항>")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "앱 버전 (AppVersion): "+getAppVersion() + "\n기기명 (Device): "+getDeviceModel()+"\nOS: " +getDeviceOs()+"\n내용 (Content)")
            emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            emailIntent.selector = emailSelectorIntent

                startActivity(emailIntent)


    }


    private fun logout() {
        /*
         logout() 메소드가 실행 되면서 로그아웃이 되고,
         로그인 화면으로 이동하게 된다.
         */
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Log.e(TAG, "로그아웃 실패. SDK에서 토큰 삭제됨", error)
            }
            else {
                Log.i(TAG, "로그아웃 성공. SDK에서 토큰 삭제됨")
            }
        }
        Toast.makeText(context, "로그아웃 되셨습니다.", Toast.LENGTH_LONG).show()
        val mIntent = Intent(context, LoginActivity::class.java)
        startActivity(mIntent)
    }


  
     fun showWithdrwalCustomDialog(){
         //회원탈퇴 다이얼로그
        Log.d(TAG + " showWithdrwalCustomDialog", "들어옴")
        val withdrwalDialog = withdrawalCustomDialog(requireContext())
        withdrwalDialog.showWithdrwalDialog()
    }




    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()//프래그먼트 뷰가 살아질 때 메모리에서 제외가 되는데 그 전에 mbinding도 null
    }

    private fun replaceView(tab: Fragment){
        //화면 변경
        var selectedFragment:Fragment? = null
        selectedFragment = tab
        selectedFragment?.let {
            val fragmentManager: FragmentManager = childFragmentManager
            fragmentManager.beginTransaction().replace(R.id.frameLayout_myPage_view, it).commit()
            fragmentManager.popBackStack()

        }
    }
    // android device id 확인
    fun getDeviceId(): String {
        return Settings.Secure.getString(requireContext().contentResolver, Settings.Secure.ANDROID_ID)
    }

    // android devcie model 확인
    fun getDeviceModel(): String {
        return Build.MODEL
    }

    // android devcie os 확인
    fun getDeviceOs(): String {
        return Build.VERSION.RELEASE.toString()
    }

    // android app version 확인
    fun getAppVersion(): String {
        val info: PackageInfo = requireContext().packageManager.getPackageInfo(requireContext().packageName, 0)
        return info.versionName
    }
}




