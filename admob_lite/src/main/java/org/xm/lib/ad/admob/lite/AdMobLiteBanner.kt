package org.xm.lib.ad.admob.lite

import android.view.ViewGroup
import org.xm.lib.ad.core.AdListener
import org.xm.lib.ad.core.BaseAd
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import org.xm.lib.core.base.App
import org.xm.lib.core.util.log


class AdMobLiteBanner : BaseAd() {
    private var mBannerView: AdView? = null
    override fun load(adPosition: String, container: ViewGroup?, adListener: AdListener?) {

    }

    override fun show() {
    }

    override fun loadAndShow(adPosition: String, container: ViewGroup?, adListener: AdListener?) {
        mBannerView = AdView(App.context)
        mBannerView?.adSize = AdSize.SMART_BANNER
        mBannerView?.adUnitId = adPosition
        mBannerView?.adListener = object : com.google.android.gms.ads.AdListener() {
            override fun onAdFailedToLoad(i: Int) {
                super.onAdFailedToLoad(i)
                adListener?.onFailed()
                log("加载AdMob Banner 失败")
            }

            override fun onAdLoaded() {
                super.onAdLoaded()
                log("加载AdMob Banner 成功")
                container?.addView(mBannerView)
            }
        }

        //加载请求
        val reqBuild = AdRequest.Builder()
        AdMobLiteHelper.testDevicesList.map {
            reqBuild.addTestDevice(it)
        }
        mBannerView?.loadAd(reqBuild.build())
    }

    override fun destroy() {
        mBannerView?.destroy()
    }
}