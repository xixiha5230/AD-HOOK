package com.xixiha.hook.application

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.highcapable.yukihookapi.hook.xposed.application.ModuleApplication
import com.xixiha.hook.service.BootReceiver
import com.xixiha.hook.utils.HotFixUtils
import com.xixiha.hook.utils.HotFixUtils.Companion.DEX_FILE
import com.xixiha.hook.utils.Update.deleteOld
import java.io.File


class XYApplication : ModuleApplication() {
    override fun onCreate() {
        super.onCreate()
        val filter = IntentFilter("com.xixiha.hook.service.StartService")
        registerReceiver(BootReceiver(), filter)
        sendBroadcast(Intent("com.xixiha.hook.service.StartService"))
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        runCatching {
            initHotFix(base!!.classLoader)
        }
    }

    /** 自动加载热更新 */
    private fun initHotFix(classLoader: ClassLoader) {
        // 删除旧版热更新
        if (File(DEX_FILE, "base.dex").exists()) deleteOld(DEX_FILE)
        // 确保热更新文件夹存在
        if (!DEX_FILE.exists()) DEX_FILE.mkdirs()
        HotFixUtils().doHotFix(classLoader)
    }
}