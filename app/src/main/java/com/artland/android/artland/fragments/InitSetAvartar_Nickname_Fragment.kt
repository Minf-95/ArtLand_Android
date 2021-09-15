package com.artland.android.artland.fragments
import android.widget.Toast
import android.content.Intent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.artland.android.artland.MainActivity
import com.artland.android.artland.R
import com.artland.android.artland.databinding.FragmentInitsetavartarAvartarBinding
import com.artland.android.artland.databinding.FragmentInitsetavartarNicknameBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class InitSetAvartar_Nickname_Fragment: Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_initsetavartar_nickname, container, false)

        view.findViewById<LinearLayout>(R.id.linearLayout_initSetAvartarNickanme_save).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_initSetAvartar_Nickname_Fragment_to_mainActivity)
        }

        view.findViewById<ImageView>(R.id.imageView_initSetAvartarNickname_back).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_initSetAvartar_Nickname_Fragment_to_initSetAvartar_Avartar_Fragment)
        }

        return view
    }



}