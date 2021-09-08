package com.artland.android.artland

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.user.UserApiClient

class LoginActivity : AppCompatActivity() {

    val TAG : String = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //View
        val kakaoSignUpContainer: LinearLayout = findViewById(R.id.kakaoSignUpContainer)//회원가입 버튼
        val kakaoLoginContainer: LinearLayout = findViewById(R.id.kakaoLoginContainer)//로그인 버튼



        //controller

        //회원가입 버튼을 눌렀을 때
        kakaoSignUpContainer.setOnClickListener {
            Log.d(TAG, "회원가입 버튼 클릭")
            showKakaoApiInformationAgreement() //카카오API 정보제공동의 화면 관련 메서드
        }//kakaoSignUpContainer.setOnClickListener


        //로그인 버튼 눌렀을 때
        kakaoLoginContainer.setOnClickListener {
            Log.d(TAG, "로그인 버튼 클릭")
            kakaoApiLoginTokenCallback() //로그인 Token값 Callback 메서드
        }// kakaoLoginContainer.setOnClickListener
    }//oncreate


    /*
    사용자에게 앱 이용 관련 동의를 구하는 동의 화면을 출력하고, 토큰 값 콜백함
    토큰 값이 잘못된 경우는 로그인 실패
    */
    fun showKakaoApiInformationAgreement(){
        UserApiClient.instance.loginWithKakaoAccount(this) { token, error ->
            if (error != null) {
                Log.e(TAG, "로그인 실패", error)
            } else if (token != null) {
                Log.i(TAG, "로그인 성공 ${token.accessToken}")
                val startMainIntent = Intent(getApplicationContext(), MainActivity::class.java)
                startActivity(startMainIntent)
            }
        }
    }


    /*
    akaoAPI를 이용해서 Token값 요청
    Token값이 있을 시 로그인
     */
    fun kakaoApiLoginTokenCallback(){
//        // 로그인 정보 확인 (토큰 값이 있으면 자동 로그인) Splash 화면에 이용
//        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
//            if (error != null) {
//                Log.d(TAG+ " kakaoApiLoginTokenCallback","토큰 정보 보기 실패")
//                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
//            }
//            else if (tokenInfo != null) {
//                Log.d(TAG+ " kakaoApiLoginTokenCallback","토큰 정보 보기 성공")
//                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                finish()
//            }
//        }

        // 로그인 공통 callback 구성
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.ServerError.toString() -> {
                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                        Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                    }
                    else -> { // Unknown
                        Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else if (token != null) {
                Log.i ("유저 토큰 값", token.toString())
                Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        } //callback




        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }//if(UserApiClienct...)
    }
}