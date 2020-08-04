package org.xm.lib.ad.amazon

import android.view.ViewGroup
import org.xm.lib.ad.core.AdListener
import org.xm.lib.ad.core.BaseAd

class AmazonVideo : BaseAd() {
    override fun load(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
        adListener?.onFailed()
    }

    override fun show() {
    }

    override fun loadAndShow(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
        adListener?.onLoaded()
    }

    override fun destroy() {
    }
}