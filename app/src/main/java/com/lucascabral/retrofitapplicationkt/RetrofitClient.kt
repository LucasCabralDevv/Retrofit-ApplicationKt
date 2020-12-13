package com.lucascabral.retrofitapplicationkt

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton
class RetrofitClient private constructor() {

    companion object {

        private lateinit var retrofit: Retrofit
        private val baseURL = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofitInstance(): Retrofit {

            val httpClient = OkHttpClient.Builder()

            if (!::retrofit.isInitialized) {

                retrofit = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun <S> createService(serviceClass: Class<S>): S {

            return getRetrofitInstance().create(serviceClass)
        }
    }
}