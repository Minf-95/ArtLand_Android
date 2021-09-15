package com.artland.android.artland

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.artland.android.artland.databinding.ActivityMainBinding
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient

class MainActivity : AppCompatActivity() {


    private val TAG:String = "MainActivity"
    private lateinit var mbinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mbinding.root)


        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)

        getUserInformationFromKakaoAPI()

        //네비게이션들을 담는 호스트
        val navHostFrament = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        //네비게이션 컨트롤러
        val navController = navHostFrament.navController

        //하단 네비게이션 뷰 와 컨트롤러를 적용시킨다.
        NavigationUI.setupWithNavController(mbinding.myBottomNav,navController)
    }



    /*
유저 정보를 KakaoAPI로부터 받아옴
 */
    fun getUserInformationFromKakaoAPI(){
        // 사용자 정보 요청 (기본)
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error)
            }
            else if (user != null) {
                Log.i(TAG, "사용자 정보 요청 성공" +
                        "\n회원번호: ${user.id}" +
                        "\n이메일: ${user.kakaoAccount?.email}" +
                        "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                        "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}")

            }
        }
    }
}