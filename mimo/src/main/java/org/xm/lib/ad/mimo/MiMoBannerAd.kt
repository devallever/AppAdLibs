package org.xm.lib.ad.mimo

import android.view.ViewGroup
import org.xm.lib.ad.core.chain.AdChainListener
import com.xiaomi.ad.common.pojo.AdType

class MiMoBannerAd : IMiMoAd(AdType.AD_BANNER) {
    override fun load(adPosition: String?, container: ViewGroup?, adListener: AdChainListener?) {
        loadAndShow(adPosition, container, adListener)
    }
}