package com.example.gamesdatabase.models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameDetailsResponse(
    val achievementsCount: Int?,
    val added: Int?,
    val additionsCount: Int?,
    val backgroundImage: String?,
    val backgroundImageAdditional: String?,
    val clip: String?,
    val creatorsCount: Int?,
    val description: String?,
    val descriptionRaw: String?,
    val gameSeriesCount: Int?,
    val genres: List<Genre>?,
    val id: Int,
    val metacritic: Int?,
    val moviesCount: Int?,
    val name: String?,
    val nameOriginal: String?,
    val parentAchievementsCount: Int?,
    val playtime: Int?,
    val rating: Double?,
    val ratingTop: Int?,
    val released: String?,
    val screenshotsCount: Int?,
    val slug: String?,
    val suggestionsCount: Int?,
    val tba: Boolean?,
    val updated: String?,
    //val userGame: Any?,
) : Parcelable
