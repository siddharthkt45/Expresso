package io.expresso.api.models.requests

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.expresso.api.models.entities.UserUpdateData

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
    @Json(name = "user")
    val user: UserUpdateData
)