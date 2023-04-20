package com.example.ass3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ass3.databinding.FragmentUpdateBinding
import com.example.ass3.db.Book
import com.example.ass3.db.MainDb


class UpdateFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpdateBinding.inflate(inflater)
        val db = MainDb.getDb(this.requireContext())

        binding.btnUpdate.setOnClickListener {
            var id =  binding.inputID.text.toString()
            var title =  binding.inputTitle.text.toString()
            var description = binding.inputDesc.text.toString()
            var cost = binding.inputCost.text.toString()
            if( title.length * description.length * cost.length *id.length !=0){


                Thread{
                    db.getDao().updateBook(Book(id.toInt(),title,description,cost.toInt()))
                }.start()
                Toast.makeText(this.requireContext(),"Done", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            UpdateFragment()
    }
}