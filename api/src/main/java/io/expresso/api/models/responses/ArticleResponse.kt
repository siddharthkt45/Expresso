package io.expresso.api.models.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.expresso.api.models.entities.Article

@JsonClass(generateAdapter = true)
data class ArticleResponse(
    @Json(name = "article")
    val article: Article
)