package com.example.journalit.model

import android.os.Parcelable

data class UserModel(
    var userId: String = "",
    var username: String = "",
    var email: String = "",
) {
}