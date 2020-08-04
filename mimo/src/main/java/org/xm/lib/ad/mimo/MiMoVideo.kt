package org.xm.lib.ad.mimo

import android.view.ViewGroup
import org.xm.lib.ad.core.AdListener
import org.xm.lib.ad.core.BaseAd
import com.miui.zeus.mimo.sdk.ad.IRewardVideoAdWorker

class MiMoVideo : BaseAd() {
    private var mAdWorker: IRewardVideoAdWorker? = null
    override fun load(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
        mAdWorker = MiMoAdHelper.loadRewardVideo(
            adPosition,
            adListener
        )
    }

    override fun show() {
        MiMoAdHelper.showVideo(mAdWorker)
    }

    override fun loadAndShow(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
//        MiMoAdHelper.loadRewardVideo()
    }

    override fun destroy() {
        MiMoAdHelper.destroyVideo(mAdWorker)
    }
}