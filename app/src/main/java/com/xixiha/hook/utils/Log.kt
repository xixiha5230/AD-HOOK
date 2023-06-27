package com.xixiha.hook.utils

import com.highcapable.yukihookapi.hook.log.loggerD
import com.highcapable.yukihookapi.hook.log.loggerE
import com.xixiha.hook.BuildConfig.TAG

object Log {
    fun d(msg: String) {
        loggerD(TAG, "------$msg------")
    }

    fun e(msg: String) {
        loggerE(TAG, "------$msg------")
    }

    fun d(TAG: String, msg: String) {
        loggerD(TAG, "------$msg------")
    }

    fun e(TAG: String, msg: String) {
        loggerE(TAG, "------$msg------")
    }
}