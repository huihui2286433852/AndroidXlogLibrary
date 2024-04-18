package com.zxxd.androidxloglibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zzxd.xloglibrary.XLogUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.btn).setOnClickListener {
            XLogUtils.f("MainActivity","我是一条日志")
            XLogUtils.e("MainActivity","我是一条日志")
            XLogUtils.w("MainActivity","我是一条日志")
            XLogUtils.i("MainActivity","我是一条日志")
            XLogUtils.d("MainActivity","我是一条日志")
            XLogUtils.v("MainActivity","我是一条日志")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        XLogUtils.appenderClose()
    }
}