package com.unhee.bestkotlin.data

import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName = "repository",
    primaryKeys = ["id"]
)
data class Repository (
    @Expose
    val id: Long,
    @Expose
    val name: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("forks_count")
    val forksCount: Int,
    @Expose
    val owner: Owner
): Serializable