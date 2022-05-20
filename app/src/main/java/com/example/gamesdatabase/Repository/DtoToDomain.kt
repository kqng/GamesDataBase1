package com.example.gamesdatabase.Repository

import androidx.lifecycle.LiveData
import com.example.gamesdatabase.Dto.GameDetailsResponseDto
import com.example.gamesdatabase.Dto.GameDto
import com.example.gamesdatabase.Dto.GamesResponseDto
import com.example.gamesdatabase.Dto.GenreDto
import com.example.gamesdatabase.models.Game
import com.example.gamesdatabase.models.GameDetailsResponse
import com.example.gamesdatabase.models.GamesResponse
import com.example.gamesdatabase.models.Genre

internal fun GamesResponseDto.toDomain(): GamesResponse {
    return GamesResponse(
        count = this.count,
        games_count = this.games_count,
        next = this.next,
        previous = this.previous,
        recommendations_count = this.recommendations_count,
        results = this.games?.map { it.toDomain() },
        reviews_count = this.reviews_count
    )

}

internal fun GenreDto.toDomain(): Genre {
    return Genre(
        games_count = this.gamesCount,
        id = this.id,
        image_background = this.imageBackground,
        name = this.name,
        slug = this.slug
    )

}

internal fun GameDto.toDomain(): Game {
    return Game(
        added = this.added,
        background_image = this.backgroundImage,
        clip = this.clip,
        community_rating = this.communityRating,
        dominant_color = this.dominantColor,
        genres = this.genres?.map { it.toDomain() },
        id = this.id,
        name = this.name,
        playtime = this.playtime,
        metacritic = this.metacritic,
        rating = this.rating,
        rating_top = this.ratingTop,
        ratings_count = this.ratingsCount,
        released = this.released,
        reviews_count = this.reviewsCount,
        reviews_text_count = this.reviewsTextCount,
        saturated_color = this.saturatedColor,
        slug = this.slug,
        suggestions_count = this.suggestionsCount,
        tba = this.tba,
        updated = this.updated
    )
}
internal fun GameDetailsResponseDto.toDomain(): GameDetailsResponse {
    return GameDetailsResponse(
        achievementsCount = this.achievementsCount,
        added = this.added,
        additionsCount = this.additionsCount,
        backgroundImage = this.backgroundImage,
        backgroundImageAdditional = this.backgroundImageAdditional,
        clip = this.clip,
        creatorsCount = this.creatorsCount,
        description = this.description,
        descriptionRaw = this.descriptionRaw,
        gameSeriesCount = this.gameSeriesCount,
        genres = this.genres?.map { it.toDomain() },
        id = this.id,
        metacritic = this.metacritic,
        moviesCount = this.moviesCount,
        name = this.name,
        nameOriginal = this.nameOriginal,
        parentAchievementsCount = this.parentAchievementsCount,
        playtime = this.playtime,
        rating = this.rating,
        ratingTop = this.ratingTop,
        released = this.released,
        screenshotsCount = this.screenshotsCount,
        slug = this.slug,
        suggestionsCount = this.suggestionsCount,
        tba = this.tba,
        updated = this.updated
    )
}