package com.artland.android.artland.fragments
import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.artland.android.artland.LoginActivity
import com.artland.android.artland.R


class InitSetAvartar_Gender_Fragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_initsetavartar_gender, container, false)

        view.findViewById<Button>(R.id.button_initSetAvartarGender_Female).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_initSetAvartar_Gender_Fragment_to_initSetAvartar_Avartar_Fragment)
        }

        view.findViewById<Button>(R.id.button_initSetAvartarGender_male).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_initSetAvartar_Gender_Fragment_to_initSetAvartar_Avartar_Fragment)
        }

        view.findViewById<ImageView>(R.id.imageView_initSetAvartarGender_back).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_initSetAvartar_Gender_Fragment_to_loginActivity)
        }

        return view
    }



}