package com.example.ass3

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ass3.databinding.ActivityMainScreenBinding
import com.example.ass3.db.MainDb

class MainScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainScreenBinding
    val adapter = BookAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDb.getDb(this)


        val extras = intent.extras
        val isAdmin = extras?.getBoolean("isAdmin")
        val btnAdmin: View = findViewById(R.id.btnAdmin)
        btnAdmin.setOnClickListener {
            if(isAdmin == true){
                val intent = Intent(this,AdminActivity::class.java)
                startActivity(intent)
            }
        }

        fun init(){
            binding.apply {
                rcView.layoutManager = LinearLayoutManager(this@MainScreenActivity)
                rcView.adapter = adapter


                db.getDao().getAllBooks().asLiveData().observe(this@MainScreenActivity) { list ->
                    adapter.adapterChangeBooks(list)
                }


                btnSearch.setOnClickListener {
                    var txt = inputSearch.text.toString()
                    db.getDao().searchBooks( txt).asLiveData().observe(this@MainScreenActivity) { list ->
                        adapter.adapterChangeBooks(list)
                    }
                }

                defaultR.setOnClickListener{
                    db.getDao().getAllBooks().asLiveData().observe(this@MainScreenActivity) { list ->
                        adapter.adapterChangeBooks(list)
                    }
                }

                ascR.setOnClickListener{
                    adapter.sortAdapterBooks(false)
                }
                descR.setOnClickListener{
                    adapter.sortAdapterBooks(true)
                }


            }
        }
        init()
    }
}