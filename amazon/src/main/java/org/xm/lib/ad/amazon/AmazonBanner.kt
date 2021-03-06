package org.xm.lib.ad.amazon

import android.view.ViewGroup
import com.amazon.device.ads.*
import org.xm.lib.ad.core.AdListener
import org.xm.lib.ad.core.BaseAd
import org.xm.lib.core.base.App
import org.xm.lib.core.util.log


class AmazonBanner : BaseAd() {

    private var adView: AdLayout? = null // The ad view used to load and display the ad.

    override fun load(adPosition: String, container: ViewGroup?, adListener: AdListener?) {

    }

    override fun show() {
    }

    override fun loadAndShow(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
        adView = AdLayout(App.context)
        container?.addView(adView)
        adView?.setListener(object : DefaultAdListener() {
            /**
             * This event is called once an ad loads successfully.
             */
            override fun onAdLoaded(ad: Ad?, adProperties: AdProperties) {
                log("Amazon Banner onAdLoaded")
                adView?.showAd()
                adListener?.onLoaded()
            }

            /**
             * This event is called if an ad fails to load.
             */
            override fun onAdFailedToLoad(ad: Ad?, error: AdError) {
                adListener?.onFailed()
                log(
                    "Ad failed to load Banner. Code: " + error.code + ", Message: " + error.message
                )
            }

            /**
             * This event is called after a rich media ad expands.
             */
            override fun onAdExpanded(ad: Ad?) {
                log("Ad expanded.")
            }

            /**
             * This event is called after a rich media ad has collapsed from an expanded state.
             */
            override fun onAdCollapsed(ad: Ad?) {
                log("Ad collapsed.")
                // Resume your activity here, if it was paused in onAdExpanded.
            }
        })
        adView?.loadAd()
    }

    override fun destroy() {
        adView?.destroy()
    }
}