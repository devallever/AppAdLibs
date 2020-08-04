package org.xm.lib.ad.core.chain

import android.view.ViewGroup
import org.xm.lib.ad.core.AdListener

abstract class IBannerAd : IAd() {
    override fun load(adPosition: String?, container: ViewGroup?, adListener: AdChainListener?) {

    }

    override fun show() {

    }

    abstract fun loadAndShow(adPosition: String?, container: ViewGroup?, adListener: AdListener?)

}