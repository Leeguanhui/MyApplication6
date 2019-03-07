package tech.wd.com.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * 适配器
 * 通过构造函数将 上下文 和 数据源 传到适配器里
 * 也可以采用次构造函数constructor（）
 */
class MyAdapter(private val context: Context, private val data: List<String>) : RecyclerView.Adapter<MyAdapter.MyVH>() {
    private var listener: OnItemClickListener? = null
//    private var context1: Context? = null
//    private var data1: ArrayList<String>? = null

//    constructor(context1: Context, data1: ArrayList<String>) {
//        this.context1 = context1
//        this.data1 = data1
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        return MyVH(LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewholder: MyVH, position: Int) {
        viewholder.textView.text = data[position]
        viewholder.itemView.setOnClickListener {
            //!! 等价于 ？ 检测是否为null
            listener!!.setOnItemClickListener(view = viewholder.itemView, int = position)
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class MyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.tv_text)
    }

    interface OnItemClickListener {
        fun setOnItemClickListener(view: View, int: Int)
    }
}
