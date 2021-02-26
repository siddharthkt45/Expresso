package io.expresso.api.services

import io.expresso.api.models.requests.LoginRequest
import io.expresso.api.models.requests.SignupRequest
import io.expresso.api.models.responses.ArticleResponse
import io.expresso.api.models.responses.ArticlesResponse
import io.expresso.api.models.responses.TagsResponse
import io.expresso.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ExpressoAPI {
    @POST("users")
    suspend fun signupUser(
        @Body userCreds: SignupRequest
    ): Response<UserResponse>

    @POST("users/login")
    suspend fun loginUser(
        @Body userCreds: LoginRequest
    ): Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favourited") favourited: String? = null,
        @Query("tag") tag: String? = null
    ): Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticleBySlug(
        @Path("slug") slug: String
    ): Response<ArticleResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>
}