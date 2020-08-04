package org.xm.lib.ad.facebook

import android.view.ViewGroup
import org.xm.lib.ad.core.AdListener
import org.xm.lib.ad.core.BaseAd
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.InterstitialAd
import com.facebook.ads.InterstitialAdListener
import org.xm.lib.core.base.App
import org.xm.lib.core.util.log


class FacebookInsert : BaseAd() {
    private var interstitialAd: InterstitialAd? = null
    override fun load(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
        interstitialAd = InterstitialAd(App.context, adPosition)
        interstitialAd?.setAdListener(object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad) {
                adListener?.onShowed()
            }

            override fun onInterstitialDismissed(ad: Ad) {
                adListener?.onDismiss()
            }

            override fun onError(ad: Ad, adError: AdError) {
                adListener?.onFailed()
                log("加载Facebook insert 失败 code = ${adError.errorCode}, message: ${adError.errorMessage}")
            }

            override fun onAdLoaded(ad: Ad) {
                adListener?.onLoaded()
                log("加载Facebook insert 成功")
            }

            override fun onAdClicked(ad: Ad) {
                adListener?.onClick()
            }

            override fun onLoggingImpression(ad: Ad) {

            }
        })
        interstitialAd?.loadAd()
    }

    override fun show() {
        interstitialAd?.show()
    }

    override fun loadAndShow(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
    }

    override fun destroy() {
        interstitialAd?.destroy()
    }
}