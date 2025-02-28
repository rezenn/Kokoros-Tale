package com.example.kokoro.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kokoro.R
import com.example.kokoro.model.BookModel
import com.example.kokoro.ui.activity.UpdateBookActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class BookAdapter(val context: Context, var data: ArrayList<BookModel>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.getBookImage)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar3)
        val editButton: TextView = itemView.findViewById(R.id.lblBookEdit)
        val sTitle: TextView = itemView.findViewById(R.id.displayBookTitle)
        val sGenre: TextView = itemView.findViewById(R.id.displayGenre)
        val sAuthor: TextView = itemView.findViewById(R.id.displayAuthor)
        val sDesc: TextView = itemView.findViewById(R.id.displayDescriptionBook)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView: View = LayoutInflater.from(context).inflate(R.layout.sample_book, parent, false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return if (data.isEmpty()) 0 else data.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = data[position]
        Log.d("BookAdapter", "Book at position $position: $book")

        holder.sTitle.text = book.bookTitle ?: "No Title"
        holder.sGenre.text = book.bookGenre ?: "No Genre"
        holder.sAuthor.text = book.bookAuthor ?: "No Author"
        holder.sDesc.text = book.bookThoughts ?: "No Description"

        // Handle image loading
        if (!book.bookimageUrl.isNullOrEmpty()) {
            Picasso.get().load(book.bookimageUrl).into(holder.imageView, object : Callback {
                override fun onSuccess() {
                    holder.progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    holder.progressBar.visibility = View.GONE
                    holder.imageView.setImageResource(R.drawable.placeholder) // Fallback image
                }
            })
        } else {
            holder.imageView.setImageResource(R.drawable.placeholder) // Fallback image
            holder.progressBar.visibility = View.GONE
        }

        // Toggle description expansion on click
        holder.sDesc.setOnClickListener {
            val isExpanded = holder.sDesc.maxLines == Integer.MAX_VALUE
            if (isExpanded) {
                // Collapse the description
                holder.sDesc.maxLines = 5
            } else {
                // Expand the description
                holder.sDesc.maxLines = Integer.MAX_VALUE
            }
        }
    }

    fun updateData(books: List<BookModel>) {
        data.clear()
        data.addAll(books)
        notifyDataSetChanged()
    }

    fun getBookId(position: Int): String {
        return data[position].bookId
    }
}
