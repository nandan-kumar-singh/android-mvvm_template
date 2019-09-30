package com.oppo.finance.model.api

import com.oppo.finance.model.bean.*
import retrofit2.http.*



interface APIService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    @GET("/article/list/{page}/json")
    suspend fun getHomeArticles(@Path("page") page: Int): DataResponce<ArticleList>

    @GET("/banner/json")
    suspend fun getBanner(): DataResponce<List<Banner>>

    @GET("/tree/json")
    suspend fun getSystemType(): DataResponce<List<SystemParent>>

    @GET("/article/list/{page}/json")
    suspend fun getSystemTypeDetail(@Path("page") page: Int, @Query("cid") cid: Int): DataResponce<ArticleList>

    @GET("/navi/json")
    suspend fun getNavigation(): DataResponce<List<Navigation>>

    @GET("/project/tree/json")
    suspend fun getProjectType(): DataResponce<List<SystemParent>>

    @GET("/wxarticle/chapters/json")
    suspend fun getBlogType(): DataResponce<List<SystemParent>>

    @GET("/wxarticle/list/{id}/{page}/json")
    fun getBlogArticle(@Path("id") id: Int, @Path("page") page: Int): DataResponce<ArticleList>

    @GET("/project/list/{page}/json")
    suspend fun getProjectTypeDetail(@Path("page") page: Int, @Query("cid") cid: Int): DataResponce<ArticleList>

    @GET("/article/listproject/{page}/json")
    suspend fun getLastedProject(@Path("page") page: Int): DataResponce<ArticleList>

    @GET("/friend/json")
    suspend fun getWebsites(): DataResponce<List<Hot>>

    @GET("/hotkey/json")
    suspend fun getHot(): DataResponce<List<Hot>>

    @FormUrlEncoded
    @POST("/article/query/{page}/json")
    suspend fun searchHot(@Path("page") page: Int, @Field("k") key: String): DataResponce<ArticleList>

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): DataResponce<User>

    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(@Field("username") userName: String, @Field("password") passWord: String, @Field("repassword") rePassWord: String): DataResponce<User>

    @GET("/lg/collect/list/{page}/json")
    suspend fun getCollectArticles(@Path("page") page: Int): DataResponce<ArticleList>

    @POST("/lg/collect/{id}/json")
    suspend fun collectArticle(@Path("id") id: Int): DataResponce<ArticleList>

    @POST("/lg/uncollect_originId/{id}/json")
    suspend fun cancelCollectArticle(@Path("id") id: Int): DataResponce<ArticleList>


}