package io.expresso.api

import io.expresso.api.services.ExpressoAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ExpressoClient {
    val retrofit: Retrofit = Retrofit.Builder()
                                    .baseUrl("https://conduit.productionready.io/api/")
                                    .addConverterFactory(MoshiConverterFactory.create())
                                    .build()

    val api = retrofit.create(ExpressoAPI::class.java)
}