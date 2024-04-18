package com.zxxd.androidxloglibrary

import android.app.Application
import com.zzxd.xloglibrary.XLogUtils

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        val logPath = cacheDir.path + "/xlog/"
        XLogUtils.init(//初始化xlog
            level= XLogUtils.LEVEL_DEBUG,//日志等级
            logPath = logPath,//日志保存路径
            isConsoleLogOpen = true,//是否打印到控制台
            cacheDays = 0)//日志保存天数
    }
}