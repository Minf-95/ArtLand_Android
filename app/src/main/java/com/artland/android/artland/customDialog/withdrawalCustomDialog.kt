package com.example.example_kakaologin.customDialog
import android.widget.Toast

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.Window
import android.widget.LinearLayout
import com.artland.android.artland.LoginActivity
import com.artland.android.artland.R


import com.kakao.sdk.user.UserApiClient

class withdrawalCustomDialog (context: Context) {
    private val dialog = Dialog(context)
    private val mContext = context
    private val TAG:String ="withdrwalCustomDialog"

    fun showWithdrwalDialog(){
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.withdrwal_dialog)

        val withdrwalCancel = dialog.findViewById<LinearLayout>(R.id.withdrwal_cancel)
        val withdrwalApply = dialog.findViewById<LinearLayout>(R.id.withdrwal_apply)

        //취소버튼 눌렀을때
        withdrwalCancel.setOnClickListener {
            dialog.dismiss()
        }

        //삭제버튼 눌렀을때
        withdrwalApply.setOnClickListener {
            // 연결 끊기
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    Log.e(TAG, "연결 끊기 실패", error)
                } else {
                    Log.i(TAG, "연결 끊기 성공. SDK에서 토큰 삭제 됨")
                }
            }
            Toast.makeText(mContext,"회원탈퇴 되셨습니다. ",Toast.LENGTH_LONG).show()
            val mInten = Intent(mContext, LoginActivity::class.java)
            mContext.startActivity(mInten)
        }

        dialog.show()
    }
}