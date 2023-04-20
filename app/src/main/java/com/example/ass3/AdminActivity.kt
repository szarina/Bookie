package com.example.ass3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ass3.databinding.ActivityAdminBinding
import com.example.ass3.databinding.ActivityMainScreenBinding

class AdminActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction().
            replace(com.google.android.material.R.id.container,InsertFragment.newInstance())
            .commit()

        binding.updateRadio.setOnClickListener {
            supportFragmentManager
                .beginTransaction().
                replace(com.google.android.material.R.id.container,UpdateFragment.newInstance())
                .commit()
        }

        binding.insertRadio.setOnClickListener{
            supportFragmentManager
                .beginTransaction().
                replace(com.google.android.material.R.id.container,InsertFragment.newInstance())
                .commit()
        }

        binding.deleteRadio.setOnClickListener{
            supportFragmentManager
                .beginTransaction().
                replace(com.google.android.material.R.id.container,DeleteFragment.newInstance())
                .commit()
        }


    }
}