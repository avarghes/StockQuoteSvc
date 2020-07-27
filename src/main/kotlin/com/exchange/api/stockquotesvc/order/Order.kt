package com.exchange.api.stockquotesvc.order

import java.time.LocalDate

data class Order(
        val id:String,
        val type:OrderType? = null,
        val triggerPrice:Float? = null,
        val executedPrice:Float? = null,
        val quantity:Int? = null,
        val scrip:String,
        var createdDate: LocalDate? = null,
        var processedDate:LocalDate? = null,
        val depositoryId: String? = null,
        var status: OrderStatus? = null
)