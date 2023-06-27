package com.xixiha.hook.hook.app

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import com.highcapable.yukihookapi.hook.factory.MembersType
import com.xixiha.hook.hook.sdk.KWAD
import com.xixiha.hook.hook.sdk.Tencent

/** 堆糖 */
object DuiTang : YukiBaseHooker() {
    override fun onHook() {
        loadHooker(Tencent)
        loadHooker(KWAD)
        findClass("com.bytedance.sdk.openadsdk.TTAdConfig").hook {
            injectMember {
                method { name = "getSdkInfo" }
                replaceTo(null)
            }
        }.ignoredHookClassNotFoundFailure()

        findClass("com.bytedance.sdk.openadsdk.TTAdSdk").hook {
            injectMember {
                method { name = "isInitSuccess" }
                replaceToTrue()
            }
        }.ignoredHookClassNotFoundFailure()

        findClass("com.bytedance.sdk.openadsdk.AdSlot").hook {
            injectMember {
                allMembers(type = MembersType.ALL)
                afterHook { }
            }
        }.ignoredHookClassNotFoundFailure()

        findClass("com.bytedance.sdk.openadsdk.AdSlot.Builder").hook {
            injectMember {
                allMembers(type = MembersType.ALL)
                replaceTo(null)
            }
        }.ignoredHookClassNotFoundFailure()
    }
}