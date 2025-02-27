package com.example.kokoro.model

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class BookModel (
    var bookId: String = "",
    var bookTitle: String = "",
    var bookGenre: String = "",
    var bookAuthor: String = "",
    var bookReleaseDate: Date = Date(),
    var bookRate: Int = 0,
    var bookThoughts: String = "",
    var bookimageUrl: String = "",
    var timestamp: Long = System.currentTimeMillis()
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        Date(parcel.readLong()),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readLong()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(bookId)
        parcel.writeString(bookTitle)
        parcel.writeString(bookGenre)
        parcel.writeString(bookAuthor)
        parcel.writeInt(bookRate)
        parcel.writeString(bookThoughts)
        parcel.writeString(bookimageUrl)
        parcel.writeLong(timestamp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookModel> {
        override fun createFromParcel(parcel: Parcel): BookModel {
            return BookModel(parcel)
        }

        override fun newArray(size: Int): Array<BookModel?> {
            return arrayOfNulls(size)
        }
    }
}