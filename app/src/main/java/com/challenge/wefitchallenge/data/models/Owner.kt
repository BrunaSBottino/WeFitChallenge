package com.challenge.wefitchallenge.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Owner(
    @PrimaryKey val owner_id:Int=0,
    @ColumnInfo val avatar_url: String=""
)