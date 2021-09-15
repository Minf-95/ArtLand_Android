package com.artland.android.artland

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artland.android.artland.databinding.ActivityInitSetAvartarBinding
import com.artland.android.artland.databinding.ActivityMainBinding

class InitSetAvartarActivity : AppCompatActivity() {

    private lateinit var mbinding: ActivityInitSetAvartarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityInitSetAvartarBinding.inflate(layoutInflater)
        setContentView(mbinding.root)


    }
}