package org.xm.lib.ad.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.xm.lib.ad.amazon.AmazonAdHelper
import org.xm.lib.ad.core.AdListener
import org.xm.lib.ad.core.BaseAd
import org.xm.lib.core.base.App

class MainActivity : AppCompatActivity() {
    private var bannerAd: BaseAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bannerAd = AmazonAdHelper.createBannerAd()
        bannerAd?.loadAndShow("", bannerContainer, object : AdListener {
            override fun onLoaded() {

            }

            override fun onShowed() {
            }

            override fun onDismiss() {
            }

            override fun onFailed() {
            }

        })

    }
}