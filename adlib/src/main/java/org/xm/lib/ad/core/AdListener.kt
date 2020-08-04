package org.xm.lib.ad.core

@Deprecated("")
interface AdListener {
    fun onLoaded()

    fun onShowed()

    fun onDismiss()

    fun onFailed()

    fun playEnd() {}

    fun onStimulateSuccess() {}

    fun onClick() {}
}