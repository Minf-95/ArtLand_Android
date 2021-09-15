package com.artland.android.artland.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.artland.android.artland.R


class InitSetAvartar_Avartar_Fragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_initsetavartar_avartar, container, false)

        view.findViewById<LinearLayout>(R.id.linearLayout_initSetAvartarAvartar_save).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_initSetAvartar_Avartar_Fragment_to_initSetAvartar_Nickname_Fragment)
        }

        view.findViewById<ImageView>(R.id.imageView_initSetAvartarAvartar_back).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_initSetAvartar_Avartar_Fragment_to_initSetAvartar_Gender_Fragment)
        }

        return view
    }
}