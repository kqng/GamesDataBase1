package com.example.gamesdatabase.Dto

import com.google.gson.annotations.SerializedName

data class GameDetailsResponseDto(
    @SerializedName("achievements_count")
    val achievementsCount: Int?,

    @SerializedName("added")
    val added: Int?,

    @SerializedName("additions_count")
    val additionsCount: Int?,

    @SerializedName("background_image")
    val backgroundImage: String?,

    @SerializedName("background_image_additional")
    val backgroundImageAdditional: String?,

    @SerializedName("clip")
    val clip: String?,

    @SerializedName("creators_count")
    val creatorsCount: Int?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("description_raw")
    val descriptionRaw: String?,

    @SerializedName("game_series_count")
    val gameSeriesCount: Int?,

    @SerializedName("genres")
    val genres: List<GenreDto>?,

    @SerializedName("id")
    val id: Int,

    @SerializedName("metacritic")
    val metacritic: Int?,

    @SerializedName("movies_count")
    val moviesCount: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("name_original")
    val nameOriginal: String?,

    @SerializedName("parent_achievements_count")
    val parentAchievementsCount: Int?,

    @SerializedName("playtime")
    val playtime: Int?,

    @SerializedName("rating")
    val rating: Double?,

    @SerializedName("rating_top")
    val ratingTop: Int?,

    @SerializedName("released")
    val released: String?,

    @SerializedName("screenshots_count")
    val screenshotsCount: Int?,

    @SerializedName("slug")
    val slug: String?,

    @SerializedName("suggestions_count")
    val suggestionsCount: Int?,

    @SerializedName("tba")
    val tba: Boolean?,

    @SerializedName("updated")
    val updated: String?
)
