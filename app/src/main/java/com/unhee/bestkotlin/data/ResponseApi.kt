package com.unhee.bestkotlin.data

import com.google.gson.annotations.Expose


class ResponseApi(
    @Expose
    val totalCount: Int,
    @Expose
    val incompleteResults: Boolean,
    @Expose
    val items: List<Repository>
)