package com.example.ass3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.asLiveData
import com.example.ass3.databinding.ActivityStartBinding
import com.example.ass3.db.MainDb

class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_start)
        setContentView(binding.root)
        val db = MainDb.getDb(this)

        fun toMainScreen(username: String, password: String) {
            if (password.length * username.length != 0) {
                db.getDao().getAllUsers().asLiveData().observe(this) { list ->
                    list.forEach {
                        if (it.username == username && it.password == password) {
                            val intent = Intent(this, MainScreenActivity::class.java)
                            intent.putExtra("isAdmin",it.isAdmin)
                            startActivity(intent)
                        }
                    }
                }
            }

        }

        binding.signInButton.setOnClickListener {
            var userName = binding.username.text.toString()
            var password = binding.password.text.toString()
            toMainScreen(userName,password)

        }



    }

    fun toSignUp(view: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)

    }

}