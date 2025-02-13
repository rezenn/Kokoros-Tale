package com.example.journalit.model

import android.os.Parcel
import android.os.Parcelable

data class StoryModel (
    var storyId: String ="",
    var storyName: String ="",
    var storyDesc: String ="",
    var imageUrl: String ="",
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(storyId)
        parcel.writeString(storyName)
        parcel.writeString(storyDesc)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StoryModel> {
        override fun createFromParcel(parcel: Parcel): StoryModel {
            return StoryModel(parcel)
        }

        override fun newArray(size: Int): Array<StoryModel?> {
            return arrayOfNulls(size)
        }
    }

}