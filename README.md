### 1.快速使用Xlog工具
1.下载AndroidXlogLibrary工程
2.在Android Studio中打开导入 xloglibrary module
3.在你的工程中添加 xloglibrary 依赖
4.在Application的onCreate方法中初始化XlogUtiles

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

5.在应用退出的时候调用

        XLogUtils.appenderClose()


### 2.Xlog工具使用方法

        findViewById<Button>(R.id.btn).setOnClickListener {
            XLogUtils.f("MainActivity","我是一条日志")
            XLogUtils.e("MainActivity","我是一条日志")
            XLogUtils.w("MainActivity","我是一条日志")
            XLogUtils.i("MainActivity","我是一条日志")
            XLogUtils.d("MainActivity","我是一条日志")
            XLogUtils.v("MainActivity","我是一条日志")
        }

