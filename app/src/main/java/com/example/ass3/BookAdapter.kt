package com.example.ass3

import android.media.audiofx.EnvironmentalReverb
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ass3.databinding.BookItemBinding
import com.example.ass3.db.Book

class BookAdapter:RecyclerView.Adapter<BookAdapter.BookHolder>() {
    val bookList = ArrayList<Book>()

    class BookHolder(item : View) :RecyclerView.ViewHolder(item){
        val binding  = BookItemBinding.bind(item)

        fun bind(book: Book) = with(binding){
            bookImage.setImageResource(R.drawable.book)
            tvID.text = book.id.toString()
            tvTitle.text = book.title
            tvDescription.text = book.description
            tvCost.text = book.cost.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        return BookHolder(view)
    }



    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.bind(bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }


    fun adapterChangeBooks(books:List <Book>){
        bookList.clear()
        books.forEach{book-> bookList.add(book)}
        notifyDataSetChanged()
    }

    fun sortAdapterBooks(desc:Boolean){
        bookList.sortWith(compareBy({it.cost}))
        if(desc){
            bookList.reverse()
        }
        notifyDataSetChanged()
    }


}