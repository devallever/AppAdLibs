package org.xm.lib.ad.facebook

import android.view.View
import android.view.ViewGroup
import com.facebook.ads.*
import org.xm.lib.ad.core.chain.AdChainListener
import org.xm.lib.ad.core.chain.IAd
import org.xm.lib.core.util.log

class FacebookBannerAd: IAd() {

    private var bannerAd: AdView? = null

    override fun load(adPosition: String?, container: ViewGroup?, adListener: AdChainListener?) {
    }

    override fun show() {
    }

    override fun loadAndShow(
        adPosition: String?,
        container: ViewGroup?,
        adListener: AdChainListener?
    ) {
        bannerAd = AdView(container?.context, adPosition, AdSize.BANNER_HEIGHT_50)
        bannerAd?.setAdListener(object : AdListener {
            override fun onAdClicked(ad: Ad?) {
                log("Facebook BannerAd 被点击")
                adListener?.onClick()
            }

            override fun onError(ad: Ad?, error: AdError?) {
                log("加载 Facebook Insert 失败, 错误码： ${error?.errorCode}")
                adListener?.onFailed("加载 Facebook Banner 失败, 错误码： ${error?.errorCode} - ${error?.errorMessage}")
            }

            override fun onAdLoaded(ad: Ad?) {
                adListener?.onLoaded(this@FacebookBannerAd)
                log("加载 Facebook Banner 成功")
            }

            override fun onLoggingImpression(ad: Ad?) {
                log("Facebook Banner onLoggingImpression()")
            }
        })
        container?.visibility = View.VISIBLE
        container?.addView(bannerAd)
        bannerAd?.loadAd()
    }

    override fun destroy() {
        bannerAd?.destroy()
    }

    override fun onAdResume() {
    }

    override fun onAdPause() {
    }
}