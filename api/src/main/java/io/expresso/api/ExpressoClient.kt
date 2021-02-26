package io.expresso.api

import io.expresso.api.services.ExpressoAPI
import io.expresso.api.services.ExpressoAuthAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ExpressoClient {
    val authToken: String? = null

    private val authInterceptor = Interceptor { chain ->  
        var req = chain.request()
        authToken?.let {
            req = req.newBuilder()
                        .header("Authorization", "Token $it")
                        .build()
        }
        chain.proceed(req)
    }

    val okHttpBuilder = OkHttpClient.Builder()
                                    .readTimeout(5, TimeUnit.SECONDS)
                                    .connectTimeout(2, TimeUnit.SECONDS)

    val retrofitBuilder = Retrofit.Builder()
                                    .baseUrl("https://conduit.productionready.io/api/")
                                    .addConverterFactory(MoshiConverterFactory.create())

    val publicApi = retrofitBuilder
                    .client(okHttpBuilder.build())
                    .build()
                    .create(ExpressoAPI::class.java)

    val authApi = retrofitBuilder
                    .client(okHttpBuilder.addInterceptor(authInterceptor).build())
                    .build()
                    .create(ExpressoAuthAPI::class.java)
}