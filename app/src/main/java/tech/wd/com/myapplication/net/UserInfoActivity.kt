package tech.wd.com.myapplication.net

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import tech.wd.com.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tech.wd.com.myapplication.NewsAdapter

class UserInfoActivity : AppCompatActivity() {
    val baseUrl: String = "https://mobile.bwstudent.com/techApi/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net)
        //val listView = findViewById<ListView>(R.id.listview)
        //val t = findViewById<TextView>(R.id.tt)
        val recyclerView = findViewById<RecyclerView>(R.id.recy) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //tt.setText("1111");
        val api = retrofit.create(Api::class.java)
        /* //使用RxJava操作符实现网络请求
         api.getFollowers()
                 .subscribeOn(Schedulers.io())
                 .unsubscribeOn(AndroidSchedulers.mainThread())
                 .subscribe({ result ->
                     println(result.toString())
                 }, { error ->
                     println(error.message)
                 }, {
                     println("complete")
                 })*/
        //请求网络，通过返回的call对象实现
//        api.getSubscrptions()
//                .enqueue(object : Callback<List<SubscriptionsEntity>> {
//                    override fun onFailure(call: Call<List<SubscriptionsEntity>>?, t: Throwable?) {
//                        println(t!!.localizedMessage)
//                    }
//
//                    override fun onResponse(call: Call<List<SubscriptionsEntity>>?, response: Response<List<SubscriptionsEntity>>?) {
//                        if (response!!.isSuccessful) {
////                            println(response.body().toString())
//                            val list = response.body()
//                            for (entity: SubscriptionsEntity in list!!) {
//                                val owner = entity.owner
//                            }
//                        }
//                    }
//                })
        /*api.getUserInfo("HexlDL")
                .enqueue(object : Callback<UserInfoEntity> {
                    override fun onFailure(call: Call<UserInfoEntity>?, t: Throwable?) {
                        println(t?.localizedMessage)
                    }

                    override fun onResponse(call: Call<UserInfoEntity>?, response: Response<UserInfoEntity>?) {
                        println(response?.message())
                        val userInfoEntity = response?.body()
                        println(userInfoEntity.toString())
                        println("用户名：${userInfoEntity?.login}  id: ${userInfoEntity?.id}  nodeId：${userInfoEntity?.node_id}")
                    }
                })*/
        api.getList(0, 1, 10)
            .enqueue(object : Callback<HomeListData> {
                override fun onResponse(call: Call<HomeListData>, response: Response<HomeListData>) {
                    println(response?.message())
                    val body = response?.body()
                    val result = body?.result
                    //tt.text = result?.get(0)?.title
                    println(result?.get(0)?.thumbnail)
                    var adapter = NewsAdapter(this, result)
                    adapter.setOnKotlinItemClickListener(object :NewsAdapter.onClickListener{
                        override fun onItemClickListener(position: Int) {
                            Toast.makeText(applicationContext, result!![position].title, Toast.LENGTH_SHORT).show()
                        }
                    })
                    recyclerView.adapter = adapter
                }

                override fun onFailure(call: Call<HomeListData>, t: Throwable) {
                    println(t?.localizedMessage)
                }
            })
    }
}