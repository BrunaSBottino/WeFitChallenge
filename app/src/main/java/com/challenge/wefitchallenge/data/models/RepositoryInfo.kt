package com.challenge.wefitchallenge.data.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RepositoryInfo(
    @PrimaryKey(autoGenerate = true) val repositoryInfoId:Int,
    @ColumnInfo(name = "description") val description: String? = "",
    @ColumnInfo(name = "full_name") val full_name: String? = "",
    @ColumnInfo(name = "html_url") val html_url: String? = "",
    @ColumnInfo(name = "language") val language: String? = "",
    @ColumnInfo(name = "stargazers_count") val stargazers_count: Int? = 0,
    @Embedded val owner: Owner,
)