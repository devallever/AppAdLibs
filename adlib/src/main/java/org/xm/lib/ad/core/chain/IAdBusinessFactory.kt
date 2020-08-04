package org.xm.lib.ad.core.chain

interface IAdBusinessFactory {

    fun getAdBusiness(businessName: String): IAdBusiness?

}