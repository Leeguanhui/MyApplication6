package tech.wd.com.myapplication

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.zx_xrecycler_item.view.*
import retrofit2.Callback
import tech.wd.com.myapplication.net.HomeListData
import tech.wd.com.myapplication.net.Result

/**
 * 作者：夏洪武
 * 时间：2019/3/8.
 * 邮箱：
 * 说明：

 */
class NewsAdapter(userInfoActivity: Callback<HomeListData>,var result: List<Result>?) : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
         return ViewHolder(View.inflate(p0?.context,R.layout.zx_xrecycler_item,null))
    }

    override fun getItemCount(): Int = result!!.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        with(p0?.itemView!!){
            title?.text=result!!.get(p1).title
            content?.text=result!!.get(p1).summary
            writer?.text=result!!.get(p1).source
            data?.text=result!!.get(p1).releaseTime.toString()
            share?.text=result!!.get(p1).share.toString()
            
        }
    }

    class ViewHolder(item :View):RecyclerView.ViewHolder(item)

}