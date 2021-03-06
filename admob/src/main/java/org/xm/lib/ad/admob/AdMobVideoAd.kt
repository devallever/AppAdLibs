package org.xm.lib.ad.admob

import android.view.ViewGroup
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import org.xm.lib.ad.core.chain.AdChainListener
import org.xm.lib.ad.core.chain.IAd
import org.xm.lib.core.base.App
import org.xm.lib.core.helper.ActivityHelper
import org.xm.lib.core.util.log


class AdMobVideoAd : IAd() {

    private var rewardedAd: RewardedAd? = null
    private var mAdListener: AdChainListener? = null

    override fun load(adPosition: String?, container: ViewGroup?, adListener: AdChainListener?) {
        rewardedAd = RewardedAd(App.context, adPosition)
        try {
            rewardedAd?.loadAd(
                AdMobHelper.createAdRequest(),
                object : RewardedAdLoadCallback() {
                    override fun onRewardedAdLoaded() {
                        log("AdMob 激励视频 加载成功")
                        adListener?.onLoaded(this@AdMobVideoAd)
                    }

                    override fun onRewardedAdFailedToLoad(errorCode: Int) {
                        log("AdMob 激励视频 加载失败： $errorCode")
                        AdMobHelper.logError(errorCode)
                        adListener?.onFailed("AdMob 激励视频 加载失败： $errorCode")
                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
            log("请求报错 AdMob Video：${e.message}")
            adListener?.onFailed("请求报错 AdMob Video：${e.message}")
        } catch (e: Error) {
            e.printStackTrace()
            log("请求报错 AdMob Video：${e.message}")
            adListener?.onFailed("请求报错 AdMob Video：${e.message}")
        }
        mAdListener = adListener
    }

    override fun show() {
        val adCallback = object : RewardedAdCallback() {
            override fun onRewardedAdOpened() {
                // Ad opened.
                log("AdMob 激励视频 Ad onRewardedAdOpened. ")
                mAdListener?.onShowed()
            }

            override fun onRewardedAdClosed() {
                // Ad closed.
                log("AdMob 激励视频 Ad closed. ")
                mAdListener?.onDismiss()
            }

            override fun onUserEarnedReward(rewardItem: RewardItem) {
                // User earned reward.
                log("AdMob 激励视频 onUserEarnedReward ")
            }

            override fun onRewardedAdFailedToShow(errorCode: Int) {
                // Ad failed to display
                log("AdMob 激励视频 onRewardedAdFailedToShow $errorCode")
            }
        }
        rewardedAd?.show(ActivityHelper.getTopActivity(), adCallback)
    }

    override fun loadAndShow(
        adPosition: String?,
        container: ViewGroup?,
        adListener: AdChainListener?
    ) {
    }

    override fun destroy() {
    }

    override fun onAdResume() {

    }

    override fun onAdPause() {

    }
}