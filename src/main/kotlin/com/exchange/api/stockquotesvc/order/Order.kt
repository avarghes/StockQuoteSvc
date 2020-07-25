package com.exchange.api.stockquotesvc.order

data class Order(
        val id:String?,
        val type:OrderType?,
        val price:Float?
)