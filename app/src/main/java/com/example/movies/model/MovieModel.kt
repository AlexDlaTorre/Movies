package com.example.movies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieModel(
    val id: Int? = null,
    val poster_path: String? = null,
    val overview: String? = null,
    val title: String? = null,
    val popularity: Double? = 0.0,
    val vote_average: Double? = 0.0,
    val release_date: String? = null,
    @Transient
    var release_date_detail: String? = "",
    @Transient
    var rate: Int = 0
) : Parcelable
