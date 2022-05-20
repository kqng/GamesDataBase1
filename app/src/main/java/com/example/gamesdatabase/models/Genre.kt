package com.example.gamesdatabase.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val games_count: Int?,
    val id: Int?,
    val image_background: String?,
    val name: String?,
    val slug: String?
) : Parcelable
