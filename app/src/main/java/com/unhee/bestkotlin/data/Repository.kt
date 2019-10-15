package com.unhee.bestkotlin.data

import androidx.room.Entity
import com.google.gson.annotations.Expose
import java.io.Serializable

@Entity(
    tableName = "repository",
    primaryKeys = ["id"]
)
data class Repository (
    @Expose
    val id: Long,
    @Expose
    val stargazersCount: Int,
    @Expose
    val owner: Owner
): Serializable