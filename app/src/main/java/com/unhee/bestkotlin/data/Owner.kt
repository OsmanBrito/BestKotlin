package com.unhee.bestkotlin.data

import androidx.room.Entity
import com.google.gson.annotations.Expose
import java.io.Serializable

@Entity(
    tableName = "owner",
    primaryKeys = ["id"]
)
data class Owner (
    @Expose
    val id: Long,
    @Expose
    val photo: String,
    @Expose
    val name: String
): Serializable