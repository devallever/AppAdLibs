package org.xm.lib.ad.sample

import org.xm.lib.ad.amazon.AmazonAdHelper
import org.xm.lib.core.base.App


class MyApp : App(){
    override fun onCreate() {
        super.onCreate()
        AmazonAdHelper.init(App.context, "1a2eea32d6154241b7856e010f1ffdee")
    }
}