package com.exchange.api.stockquotesvc.order

data class OrderResponse(val orderid:String? = null ,val scripName:String? = null,
                         val quantity:Int? = null,
                         val triggerPrice:Float? = null,
                         val executedPrice:Float? = null,
                         val orderType: OrderType?=null,
                         val status: OrderStatus?=null)