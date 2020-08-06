package org.xm.lib.ad.facebook

import android.content.Context
import org.xm.lib.ad.core.AdManager
import org.xm.lib.ad.core.BaseAd

@Deprecated("")
object FacebookAdHelper : AdManager() {
    override fun init(context: Context, appId: String, appKey: String, appToken: String) {

    }

    override fun createBannerAd(): BaseAd? =
        FacebookBanner()

    override fun createInsertAd(): BaseAd? =
        FacebookInsert()

    override fun createVideoAd(): BaseAd? = null

    override fun createDownloadAd(): BaseAd? = null

    override fun destroy(context: Context) {
    }
}