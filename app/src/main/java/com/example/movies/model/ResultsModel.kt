package com.example.movies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultsModel(
    val page: Int,
    val results: List<MovieModel>
) : Parcelable
