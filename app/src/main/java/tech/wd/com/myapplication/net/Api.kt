package tech.wd.com.myapplication.net

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.atomic.AtomicInteger

interface Api {
    @GET("users/{path}")
    fun getUserInfo(@Path("path") string: String): Call<UserInfoEntity>

    @GET("users/kjalnes/subscriptions")
    fun getSubscrptions(): Call<List<SubscriptionsEntity>>

    @GET("users/HexlDL/followers")
    fun getFollowers():Observable<List<FollowersEntity>>

    @GET("infoRecommendList/{plateId}/{page}/{count}")
    fun getList(@Query("plateId") plateId: Int, @Query("page") page: Int, @Query("count") count: Int): Call<HomeListData>
    @GET("infoRecommendList/{plateId}{page}{count}")
    fun getLists(@Query("plateId") plateId: Int, @Query("page") page: Int, @Query("count") count: Int): Call<Result>
}