package com.example.kokoro.repository

import android.content.Context
import android.net.Uri
import com.example.kokoro.model.BookModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class BookRepositoryImpl:BookRepository {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference: DatabaseReference = database.reference.child("books")

    override fun addBook(bookModel: BookModel, callback: (Boolean, String) -> Unit) {
        val id = reference.push().key.toString()
        bookModel.bookId = id
        bookModel.timestamp = System.currentTimeMillis()

        reference.child(id).setValue(bookModel)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    callback(true, "Book Added Successfully")
                }else{
                    callback(false,"${it.exception?.message}")
                }
            }
    }

    override fun updateBook(
        bookId: String,
        data: MutableMap<String, Any>,
        callback: (Boolean, String) -> Unit
    ) {
        data["timestamp"] = System.currentTimeMillis()

        reference.child(bookId).updateChildren(data)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    callback(true,"Book Updated Successfully")
                }else{
                    callback(false,"${it.exception?.message}")
                }
            }
    }

    override fun deleteBook(bookId: String, callback: (Boolean, String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getBookById(bookId: String, callback: (BookModel?, Boolean, String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getAllBook(callback: (List<BookModel>?, Boolean, String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun uploadBookImage(context: Context, imageUri: Uri, callback: (String?) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getBookFileNameFromUri(context: Context, uri: Uri): String? {
        TODO("Not yet implemented")
    }
}