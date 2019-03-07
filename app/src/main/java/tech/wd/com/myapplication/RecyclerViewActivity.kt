package tech.wd.com.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

class RecyclerViewActivity : AppCompatActivity() {

    val data = listOf("hexl", "Dongl", "hexl", "Dongl", "hexl", "Dongl", "hexl",
            "Dongl", "hexl", "Dongl", "hexl", "Dongl", "hexl", "Dongl")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        //绑定id，这里的泛型需要指定view，kotlin会自动推断类型。
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        //设置布局管理器
        recyclerView.layoutManager = LinearLayoutManager(this)
        //初始化适配器
        val adapter = MyAdapter(this, data)
        //设置适配器
        recyclerView.adapter = adapter
        //item点击事件
        adapter.setOnItemClickListener(listener = object : MyAdapter.OnItemClickListener {
            override fun setOnItemClickListener(view: View, int: Int) {
                //kotlin 不能使用 MainActivity.this 这种方式获取 Context 对象
                // this@MainActivity、MainActivity@this，通过这两种方式获取
                Toast.makeText(this@RecyclerViewActivity, data[int], Toast.LENGTH_LONG).show()
            }
        })
    }
}
