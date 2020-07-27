package com.exchange.api.stockquotesvc.order

import java.util.*

fun generateOrderId(): String{
     val random:Random = Random();
     return "OID" + random.nextInt()
}

fun generateRequestId(): String{
     return UUID.randomUUID().toString()
}