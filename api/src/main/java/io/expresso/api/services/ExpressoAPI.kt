package io.expresso.api.services

import io.expresso.api.models.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ExpressoAPI {
    @GET("articles")
    fun getArticles(): Call<ArticlesResponse>
}