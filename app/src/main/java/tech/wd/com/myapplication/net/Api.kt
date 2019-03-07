package tech.wd.com.myapplication.net

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{path}")
    fun getUserInfo(@Path("path") string: String): Call<UserInfoEntity>

    @GET("users/kjalnes/subscriptions")
    fun getSubscrptions(): Call<List<SubscriptionsEntity>>

    @GET("users/HexlDL/followers")
    fun getFollowers():Observable<List<FollowersEntity>>
}