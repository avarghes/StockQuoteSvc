package com.exchange.api.stockquotesvc.order

data class OrderRequest(var requestId :String?, val scripName:String?,
                        val quantity:Int?,val triggerPrice:Float?,val orderType: OrderType?)