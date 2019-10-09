package com.oppo.finance.core.api

import com.oppo.finance.core.bean.*
import retrofit2.http.*


interface APIService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): DataResponse<ArticleList>

    @GET("/banner/json")
    suspend fun getBanner(): DataResponse<List<Banner>>

    @GET("/banner/json")
    suspend fun getFund(): DataResponse<Fund>

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): DataResponse<User>

    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(
        @Field("username") userName: String, @Field("password") passWord: String, @Field(
            "repassword"
        ) rePassWord: String
    ): DataResponse<User>


    @POST("/lg/collect/{id}/json")
    suspend fun collectArticle(@Path("id") id: Int): DataResponse<ArticleList>

    @POST("/lg/uncollect_originId/{id}/json")
    suspend fun cancelCollectArticle(@Path("id") id: Int): DataResponse<ArticleList>


}