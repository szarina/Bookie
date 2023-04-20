package com.example.ass3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ass3.databinding.ActivitySignUpBinding
import com.example.ass3.db.MainDb
import com.example.ass3.db.User

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDb.getDb(this)

        binding.SignUpbutton.setOnClickListener {
            var userName =  binding.username.text.toString()
            var password = binding.password.text.toString()

            if( userName.length!=0 && password.length!=0){
                var isAdmin = binding.checkBox.isChecked
                val user = User(id = null,username = userName, password = password, isAdmin = isAdmin)

                Thread{
                    db.getDao().insertUser(user)
                }.start()

                toSignIn()
            }
        }
    }

    fun toSignIn(){
        val intent = Intent(this,StartActivity::class.java)
        startActivity(intent)
    }
}