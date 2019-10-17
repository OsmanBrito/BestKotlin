package com.unhee.bestkotlin.data.entity

import androidx.room.Entity
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.unhee.bestkotlin.data.converter.OwnerConverter
import java.io.Serializable

@Entity(
    tableName = "repository",
    primaryKeys = ["id"]
)
data class Repository(
    @Expose
    val id: Long,
    @Expose
    val name: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @TypeConverters(OwnerConverter::class)
    val owner: Owner
) : Serializable