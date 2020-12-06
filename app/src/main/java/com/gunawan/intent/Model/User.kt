package com.gunawan.intent.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val stok: Int,
    val merek: String,
    val from: String,
    val where: String
) : Parcelable