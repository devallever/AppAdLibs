package org.xm.lib.ad.admob.lite

import android.content.Context
import org.xm.lib.ad.core.AdManager
import org.xm.lib.ad.core.BaseAd

object AdMobLiteHelper : AdManager() {
    var testDevicesList = mutableListOf<String>()
    override fun init(context: Context, appId: String, appKey: String, appToken: String) {
//        MobileAds.initialize(context) {
//
//        }
        testDevicesList.add("811A5A5DA1BF1E2FC9EE39041EC322FF")
        testDevicesList.add("1621DB3C172AE6711BA840F4AEF6EF48")
    }

    override fun createBannerAd(): BaseAd? {
        return AdMobLiteBanner()
    }

    override fun createInsertAd(): BaseAd? {
        return AdMobLiteInsert()
    }

    override fun createVideoAd(): BaseAd? = null

    override fun createDownloadAd(): BaseAd? = null

    override fun destroy(context: Context) {
    }
}