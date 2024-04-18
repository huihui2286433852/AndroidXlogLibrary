package com.zzxd.xloglibrary

import android.os.Environment
import com.tencent.mars.xlog.Log
import com.tencent.mars.xlog.Xlog

/**
 * XLog工具类，用来记录日志的
 */
object XLogUtils {
    const val LEVEL_ALL = 0
    const val LEVEL_VERBOSE = 0
    const val LEVEL_DEBUG = 1
    const val LEVEL_INFO = 2
    const val LEVEL_WARNING = 3
    const val LEVEL_ERROR = 4
    const val LEVEL_FATAL = 5
    const val LEVEL_NONE = 6

    const val AppednerModeAsync = 0
    const val AppednerModeSync = 1

    @Volatile
    private var isInit = false
    private var logPath: String = ""

    init {
        System.loadLibrary("c++_shared")
        System.loadLibrary("marsxlog")
    }

    /**
     * 初始化
     * @param level 日志级别
     * @param mode 日志模式
     * @param logPath 日志路径
     * @param logFilePrefix 日志文件前缀
     * @param cacheDays 日志缓存天数
     * @param isConsoleLogOpen 是否打印到控制台
     *
     */
    fun init(
        level: Int = Xlog.LEVEL_DEBUG,
        mode: Int = Xlog.AppednerModeAsync,
        logPath: String = Environment.getExternalStorageDirectory().path + "/xlog",
        logFilePrefix: String = "xlog",
        cacheDays: Int = 7,
        isConsoleLogOpen: Boolean = true,
    ) {
        if (isInit) {
            return
        }
        isInit = true
        this.logPath = logPath
        android.util.Log.i("xlog目录", logPath)
        android.util.Log.i("xlog目录", "${logPath}cache")
        Log.setLogImp(Xlog())
        Log.setConsoleLogOpen(isConsoleLogOpen)
        Log.appenderOpen(
            level,
            mode,
            "${logPath}cache",
            logPath,
            logFilePrefix,
            cacheDays
        )
    }

    /**
     * 设置显示控制台日志
     */
    fun setConsoleLogOpen(isConsoleLogOpen:Boolean){
        Log.setConsoleLogOpen(isConsoleLogOpen)
    }

    /**
     * 获取日志路径
     */
    fun getLogPath(): String {
        return this.logPath
    }

    fun appenderClose() {
        if (isInit) {
            Log.appenderClose()
            isInit = false
        }
    }

    fun f(tag: String?, msg: String?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.f(tag, msg)
        Log.appenderFlush()
    }


    fun e(tag: String?, msg: String?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.e(tag, msg)
        Log.appenderFlush()
    }

    fun w(tag: String?, msg: String?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.e(tag, msg)
        Log.appenderFlush()
    }

    fun i(tag: String?, msg: String?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.i(tag, msg)
        Log.appenderFlush()
    }

    fun d(tag: String?, msg: String?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.d(tag, msg)
        Log.appenderFlush()
    }

    fun v(tag: String?, msg: String?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.v(tag, msg)
        Log.appenderFlush()
    }

    fun f(tag: String?, format: String?, vararg obj: Any?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.f(tag, format, obj)
        Log.appenderFlush()
    }

    fun e(tag: String?, format: String?, vararg obj: Any?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.e(tag, format, obj)
        Log.appenderFlush()
    }

    fun w(tag: String?, format: String?, vararg obj: Any?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.w(tag, format, obj)
        Log.appenderFlush()
    }

    fun i(tag: String?, format: String?, vararg obj: Any?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.i(tag, format, obj)
        Log.appenderFlush()
    }

    fun d(tag: String?, format: String?, vararg obj: Any?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.d(tag, format, obj)
        Log.appenderFlush()
    }

    fun v(tag: String?, format: String?, vararg obj: Any?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.v(tag, format, obj)
        Log.appenderFlush()
    }

    fun printErrStackTrace(tag: String?, tr: Throwable?, format: String?, vararg obj: Any?) {
        if (!isInit) Log.e("XlogUtils", "请先初始化XLogUtils")
        Log.printErrStackTrace(tag, tr, format, obj)
        Log.appenderFlush()
    }

}