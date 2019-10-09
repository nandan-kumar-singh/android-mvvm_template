package com.oppo.finance.core.repository

import com.oppo.finance.core.api.BaseRepository
import com.oppo.finance.core.api.RetrofitClient
import com.oppo.finance.core.bean.ArticleList
import com.oppo.finance.core.bean.Banner
import com.oppo.finance.core.bean.DataResponse


class HomeRepository : BaseRepository() {

    suspend fun getBanners(): DataResponse<List<Banner>> {
        return apiCall { RetrofitClient.instance.getBanner() }
    }

    suspend fun getArticleList(page: Int): DataResponse<ArticleList> {
        return apiCall { RetrofitClient.instance.getHomeArticles(page) }
    }

    suspend fun collectArticle(articleId: Int): DataResponse<ArticleList> {
        return apiCall { RetrofitClient.instance.collectArticle(articleId) }
    }

    suspend fun unCollectArticle(articleId: Int): DataResponse<ArticleList> {
        return apiCall { RetrofitClient.instance.cancelCollectArticle(articleId) }
    }
}