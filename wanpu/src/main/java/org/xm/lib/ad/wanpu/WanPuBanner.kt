package org.xm.lib.ad.wanpu

import android.view.ViewGroup
import android.widget.LinearLayout
import cn.waps.AppListener
import org.xm.lib.ad.core.AdListener
import org.xm.lib.ad.core.BaseAd
import org.xm.lib.ad.wanpu.WanPuAdHelper.mIns
import org.xm.lib.core.util.log


class WanPuBanner : BaseAd() {
    override fun load(adPosition: String, container: ViewGroup?, adListener: AdListener?) {

    }

    override fun show() {
    }

    override fun loadAndShow(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
        if (container is LinearLayout) {
            mIns.setBannerAdNoDataListener(object : AppListener() {
                override fun onBannerNoData() {
                    log("Banner无数据")
                }
            })
            mIns.showBannerAd(WanPuAdHelper.mContext, container)
        } else {
            throw RuntimeException("container 必须是LinearLayout")
        }
    }

    override fun destroy() {
    }
}