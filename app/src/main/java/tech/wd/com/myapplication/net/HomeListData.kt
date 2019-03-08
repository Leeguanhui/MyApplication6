package tech.wd.com.myapplication.net

/**
 * 作者：夏洪武
 * 时间：2019/3/7.
 * 邮箱：
 * 说明：
 */

data class HomeListData(
    val message: String,
    val result: List<Result>,
    val status: String
)

data class Result(
    val collection: Int,
    val id: Int,
    val releaseTime: Long,
    val share: Int,
    val source: String,
    val summary: String,
    val thumbnail: String,
    val title: String,
    val whetherAdvertising: Int,
    val whetherCollection: Int,
    val whetherPay: Int
)