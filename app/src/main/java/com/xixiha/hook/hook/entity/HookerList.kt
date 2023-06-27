package com.xixiha.hook.hook.entity

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker

enum class HookerList(val packageName: String, val hooker: YukiBaseHooker, val stop: Boolean) {
    /** 堆糖 */
    DuiTang("com.duitang.main", com.xixiha.hook.hook.app.DuiTang,true),
    /** 最右 */
    ZuiYou("cn.xiaochuankeji.tieba", com.xixiha.hook.hook.app.ZuiYou,false),
    /** 番茄小说 */
    DragonRead("com.dragon.read", com.xixiha.hook.hook.app.DragonRead,false),
    /** 喜马拉雅 */
    XiMaLaYa("com.ximalaya.ting.android", com.xixiha.hook.hook.app.XiMaLaYa,false),
    /** App分享 */
    AppShare("info.muge.appshare", com.xixiha.hook.hook.app.AppShare,false),
    /** 腾讯动漫 */
    QQAc("com.qq.ac.android", com.xixiha.hook.hook.app.QQAc,true),
    /** 小猿搜题 */
    XYST("com.fenbi.android.solar", com.xixiha.hook.hook.app.XYST,true),
    /** QQ阅读 */
    QQReader("com.qq.reader", com.xixiha.hook.hook.app.QQReader,true),
    /** 追书小说阅读 */
    ZSRead("com.zhuishuxiaoshuo.bbzz.app", com.xixiha.hook.hook.app.ZSRead,true),
    /** 米游社 */
    MiYoHyper("com.mihoyo.hyperion", com.xixiha.hook.hook.app.MiYoHyper,true);

    companion object {
        /** 通过包名获取对应Hooker */
        fun fromPackageName(packageName: String): HashMap<String, Any>? {
            return values().find { it.packageName == packageName }?.let {
                val hooker = HashMap<String, Any>()
                hooker["hooker"] = it.hooker
                hooker["stop"] = it.stop
                return hooker
            }
        }
    }
}