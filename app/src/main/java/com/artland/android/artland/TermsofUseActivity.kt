package com.artland.android.artland
import android.content.Intent
import android.util.Log

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.artland.android.artland.databinding.ActivityMainBinding
import com.artland.android.artland.databinding.ActivityTermsofUseBinding
import org.w3c.dom.Text

class TermsofUseActivity : AppCompatActivity() {
    
    //뷰 바인딩을 위한 변수
    private lateinit var mbinding: ActivityTermsofUseBinding
    
    //정보 동의 체크에 대한 변수
    private var checkAllAgreeBol : Boolean = false
    private var checkTermOfUseAgreeBol : Boolean = false
    private var checkPrivacyAgreeBol : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityTermsofUseBinding.inflate(layoutInflater) //해당 엑티비티의 정보를 binding함(View...)
        setContentView(mbinding.root)






        mbinding.linearLayoutTermOfUseAllAgree.setOnClickListener {
            checkAllAgree() //모든 약관 동의 체크
        }
        mbinding.imageViewTermOfUseTermOfUseCheck.setOnClickListener{
            checkTermOfUse() //이용약관 동의 체크
        }
        mbinding.imageViewTermOfUsePrivacyCheck.setOnClickListener {
            checkPrivacy() //개인정보 처리방침 체크
        }
        mbinding.linearLayoutTermOfUseCompleteArgee.setOnClickListener {
            checkComplete() //모든 약관 체크
        }

    }//create()


    private fun checkComplete(){
        if(checkAllAgreeBol){
            val mIntent = Intent(getApplicationContext(), InitSetAvartarActivity::class.java)
            startActivity(mIntent)
        }else{

        }
    }


    private fun checkBothCondition(){
        /*
        개인정보 처리방침, 이용약관 두개 다 체크가 된 경우
       '네, 모두 동의합니다.' 버튼이 활성화 된다.
         */
        if(checkTermOfUseAgreeBol ==true && checkPrivacyAgreeBol==true){
            checkAllAgreeBol = true
            mbinding.linearLayoutTermOfUseAllAgree.setBackgroundResource(R.drawable.nomal_btn_border)
            mbinding.textViewTermOfUseAllAgree.setTextColor(Color.parseColor("#FFFFFF"))
            mbinding.textViewTermOfUseComplete.setTextColor(Color.parseColor("#FFFFFF"))
        }else{
            checkAllAgreeBol = false
            mbinding.linearLayoutTermOfUseAllAgree.setBackgroundResource(R.drawable.termofuse_agreebtn_border)
            mbinding.textViewTermOfUseAllAgree.setTextColor(Color.parseColor("#000000"))
            mbinding.textViewTermOfUseComplete.setTextColor(Color.parseColor("#66FFFFFF"))

        }
    }


    private fun checkTermOfUse(){
        /*
       '개인정보 처리방침' 버튼이
       클릭 되어있으면(checkPrivacyAgreeBol=true)
       개인정보 처리방침이 체크 해제가 되고

       클릭이 안되어 있으면(checkPrivacyAgreeBol=false)
       개인정보 처리방침이 체크 되게 된다.

       마지막으로 개인정보 처리방침, 이용약관 두개 다 체크가 된 경우
       '네, 모두 동의합니다.' 버튼이 활성화 된다.
        */
        if(checkTermOfUseAgreeBol){
            checkTermOfUseAgreeBol = false
            mbinding.imageViewTermOfUseTermOfUseCheck.setImageResource(R.drawable.ic_gray_check)
        }else{
            checkTermOfUseAgreeBol = true
            mbinding.imageViewTermOfUseTermOfUseCheck.setImageResource(R.drawable.ic_baseline_check_24)
        }

        checkBothCondition() // 개인정보 처리방침, 이용약관 체크 확인

        Log.d("checkTermOfUseAgreeBol", checkTermOfUseAgreeBol.toString())
        Log.d("checkPrivacyAgreeBol", checkPrivacyAgreeBol.toString())
        Log.d("checkAllAgreeBol", checkAllAgreeBol.toString())

    }

    private fun checkPrivacy(){
            /*
            '개인정보 처리방침' 버튼이
            클릭 되어있으면(checkPrivacyAgreeBol=true)
            개인정보 처리방침이 체크 해제가 되고

            클릭이 안되어 있으면(checkPrivacyAgreeBol=false)
            개인정보 처리방침이 체크 되게 된다.

            마지막으로 개인정보 처리방침, 이용약관 두개 다 체크가 된 경우
            '네, 모두 동의합니다.' 버튼이 활성화 된다.
             */
        if(checkPrivacyAgreeBol){
            checkPrivacyAgreeBol = false
            mbinding.imageViewTermOfUsePrivacyCheck.setImageResource(R.drawable.ic_gray_check)
        }else{
            checkPrivacyAgreeBol = true
            mbinding.imageViewTermOfUsePrivacyCheck.setImageResource(R.drawable.ic_baseline_check_24)
        }

        checkBothCondition()// 개인정보 처리방침, 이용약관 체크 확인

        Log.d("checkTermOfUseAgreeBol", checkTermOfUseAgreeBol.toString())
        Log.d("checkPrivacyAgreeBol", checkPrivacyAgreeBol.toString())
        Log.d("checkAllAgreeBol", checkAllAgreeBol.toString())

    }

    private fun checkAllAgree(){
        /*
        '네, 모두 동의합니다.' 버튼이
        클릭 되어있으면(checkAllAgreeBol=true)
        이용약관, 개인정보 처리방침이 체크 해제가 되고

        클릭이 안되어 있으면(checkAllAgreeBol=false)
        이용약관, 개인정보 처리방침이 체크 되게 된다.
         */
        if(checkAllAgreeBol){
            checkAllAgreeBol = false
            checkTermOfUseAgreeBol = false
            checkPrivacyAgreeBol = false

            mbinding.linearLayoutTermOfUseAllAgree.setBackgroundResource(R.drawable.termofuse_agreebtn_border)
            mbinding.textViewTermOfUseAllAgree.setTextColor(Color.parseColor("#000000"))

            mbinding.imageViewTermOfUsePrivacyCheck.setImageResource(R.drawable.ic_gray_check)
            mbinding.imageViewTermOfUseTermOfUseCheck.setImageResource(R.drawable.ic_gray_check)

            mbinding.textViewTermOfUseComplete.setTextColor(Color.parseColor("#66FFFFFF"))
        }else{
            checkAllAgreeBol = true
            checkTermOfUseAgreeBol = true
            checkPrivacyAgreeBol = true

            mbinding.linearLayoutTermOfUseAllAgree.setBackgroundResource(R.drawable.nomal_btn_border)
            mbinding.textViewTermOfUseAllAgree.setTextColor(Color.parseColor("#FFFFFF"))

            mbinding.imageViewTermOfUsePrivacyCheck.setImageResource(R.drawable.ic_baseline_check_24)
            mbinding.imageViewTermOfUseTermOfUseCheck.setImageResource(R.drawable.ic_baseline_check_24)

            mbinding.textViewTermOfUseComplete.setTextColor(Color.parseColor("#FFFFFF"))
        }

        Log.d("checkTermOfUseAgreeBol", checkTermOfUseAgreeBol.toString())
        Log.d("checkPrivacyAgreeBol", checkPrivacyAgreeBol.toString())
        Log.d("checkAllAgreeBol", checkAllAgreeBol.toString())
    }
}