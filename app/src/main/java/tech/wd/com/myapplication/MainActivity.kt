package tech.wd.com.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import tech.wd.com.myapplication.net.UserInfoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IActivity {
    override fun initLayout() {
        Toast.makeText(this, "initLayout()", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置布局
        setContentView(R.layout.activity_main)
        btn_list.setOnClickListener {
            startActivity(Intent(MainActivity@ this, RecyclerViewActivity::class.java))
            initLayout()
        }

        btn_net.setOnClickListener {
            startActivity(Intent(MainActivity@this,UserInfoActivity::class.java))
        }
    }
}
