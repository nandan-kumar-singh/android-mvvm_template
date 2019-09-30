package luyao.wanandroid.model.repository

import com.oppo.finance.model.api.BaseRepository
import com.oppo.finance.model.api.RetrofitClient
import com.oppo.finance.model.bean.ArticleList
import com.oppo.finance.model.bean.Banner
import com.oppo.finance.model.bean.DataResponce


class HomeRepository : BaseRepository() {

    suspend fun getBanners(): DataResponce<List<Banner>> {
        return apiCall { RetrofitClient.instance.getBanner() }
    }

    suspend fun getArticleList(page: Int): DataResponce<ArticleList> {
        return apiCall { RetrofitClient.instance.getHomeArticles(page) }
    }

    suspend fun collectArticle(articleId: Int): DataResponce<ArticleList> {
        return apiCall { RetrofitClient.instance.collectArticle(articleId) }
    }

    suspend fun unCollectArticle(articleId: Int): DataResponce<ArticleList> {
        return apiCall { RetrofitClient.instance.cancelCollectArticle(articleId) }
    }
}