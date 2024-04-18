### 1.快速使用XLogUtils工具
1.在settings.gradle中添加 jitpack 仓库

    maven { url 'https://jitpack.io' }

2.在module的build.gradle中添加XLogUtils依赖

    implementation 'com.github.huihui2286433852:AndroidXlogLibrary:v1.0.1'

3.在Application的onCreate方法中初始化XlogUtiles

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

4.在应用退出的时候调用

        XLogUtils.appenderClose()

### 2.XLogUtils工具使用方法

        findViewById<Button>(R.id.btn).setOnClickListener {
            XLogUtils.f("MainActivity","我是一条日志")
            XLogUtils.e("MainActivity","我是一条日志")
            XLogUtils.w("MainActivity","我是一条日志")
            XLogUtils.i("MainActivity","我是一条日志")
            XLogUtils.d("MainActivity","我是一条日志")
            XLogUtils.v("MainActivity","我是一条日志")
        }

