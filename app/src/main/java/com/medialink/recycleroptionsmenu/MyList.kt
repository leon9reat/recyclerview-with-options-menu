package com.medialink.recycleroptionsmenu

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyList(var head: String, var desc: String) : Parcelable