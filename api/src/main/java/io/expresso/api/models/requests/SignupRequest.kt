package io.expresso.api.models.requests

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.expresso.api.models.entities.SignupData

@JsonClass(generateAdapter = true)
data class SignupRequest(
    @Json(name = "user")
    val user: SignupData
)