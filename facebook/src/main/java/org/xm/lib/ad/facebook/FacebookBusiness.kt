package org.xm.lib.ad.facebook

import android.content.Context
import com.facebook.ads.AdSettings
import com.facebook.ads.AudienceNetworkAds
import org.xm.lib.ad.core.chain.IAd
import org.xm.lib.ad.core.chain.IAdBusiness

object FacebookBusiness : IAdBusiness() {

    override fun init(context: Context, appId: String, appKey: String, appToken: String) {
        AudienceNetworkAds.initialize(context)

        AdSettings.addTestDevice("96bb3dea-f978-43dd-a244-85311c1ed158")//nexus5x
        AdSettings.addTestDevice("744c0fe5-4a13-4d06-b61a-659d87446209")//pixel
    }

    override fun createBannerAd(): IAd? = FacebookBannerAd()

    override fun createInsertAd(): IAd? = FacebookInsertAd()

    override fun createVideoAd(): IAd? = null

    override fun createDownloadAd(): IAd? = null

    override fun createNativeAd(adType: String): IAd? = null

    override fun destroy(context: Context) {
    }
}