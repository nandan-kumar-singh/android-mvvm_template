package luyao.wanandroid.model.repository

import com.oppo.finance.model.api.BaseRepository
import com.oppo.finance.model.api.RetrofitClient
import com.oppo.finance.model.bean.ArticleList
import com.oppo.finance.model.bean.DataResponce
import com.oppo.finance.model.bean.SystemParent


class SystemRepository : BaseRepository() {

    suspend fun getSystemTypeDetail(id: Int, page: Int): DataResponce<ArticleList> {
        return apiCall { RetrofitClient.instance.getSystemTypeDetail(page, id) }
    }

    suspend fun getSystemTypes(): DataResponce<List<SystemParent>> {
        return apiCall { RetrofitClient.instance.getSystemType() }
    }

    suspend fun collectArticle(articleId: Int): DataResponce<ArticleList> {
        return apiCall { RetrofitClient.instance.collectArticle(articleId) }
    }

    suspend fun unCollectArticle(articleId: Int): DataResponce<ArticleList> {
        return apiCall { RetrofitClient.instance.cancelCollectArticle(articleId) }
    }

    suspend fun getBlogArticle(id: Int, page: Int): DataResponce<ArticleList> {
        return apiCall { RetrofitClient.instance.getBlogArticle(id, page) }
    }
}