package com.example.ass3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ass3.databinding.FragmentDeleteBinding
import com.example.ass3.databinding.FragmentInsertBinding
import com.example.ass3.db.Book
import com.example.ass3.db.MainDb


class DeleteFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDeleteBinding.inflate(inflater)
        val db = MainDb.getDb(this.requireContext())

        binding.btnDelete.setOnClickListener {
            var id = binding.inputID.text.toString()

            if( id.length!=0){

                Thread{
                    db.getDao().deleteBookById(id.toInt())
                }.start()
                Toast.makeText(this.requireContext(),"Done", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            DeleteFragment()

    }
}