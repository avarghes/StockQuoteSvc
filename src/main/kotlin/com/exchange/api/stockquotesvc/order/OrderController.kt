package com.exchange.api.stockquotesvc.order

import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.collections.ArrayList


@RestController
@RequestMapping("/api/v1/order")
class OrderController {

    @GetMapping("/list")
    fun getAllOrderDetails():List<Order?>{
        return ArrayList()
    }

    @GetMapping("/details/{orderid}")
    fun getOrderDetails(@PathVariable("orderid") orderId: String):Any {
        println(orderId)
        return OrderRequest(requestId = UUID.randomUUID().toString(),
                orderId = Integer.valueOf(orderId))
    }
}