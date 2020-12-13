package com.lucascabral.retrofitapplicationkt

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getList(): Call<List<PostModel>>
}