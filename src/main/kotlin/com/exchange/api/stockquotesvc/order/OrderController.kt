package com.exchange.api.stockquotesvc.order

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException
import java.util.*
import javax.websocket.server.PathParam
import kotlin.collections.ArrayList


@RestController
@RequestMapping("/api/v1/order")
class OrderController {

    @Autowired
    lateinit var ordersvc: OrderSubSystemService

    @GetMapping("/list")
    fun getAllOrderDetails():List<Order?>{
        return ArrayList()
    }

    @GetMapping("/details/{orderid}")
    fun getOrderDetails(@PathVariable("orderid") orderId: String):Any {
        return ordersvc.orderHistory(orderId)?: throw RuntimeException("Order $orderId Not Found")
    }

    @PostMapping("/execute")
    fun executeOrder(@RequestBody orderRequest: OrderRequest): Any{
        return ordersvc.createOrder(orderRequest);
    }

    @DeleteMapping("/cancel/{orderid}")
    fun cancelOrder(@PathVariable("orderid") orderid: String): Any {
        return ordersvc.cancelOrder(orderid)?: throw RuntimeException("Order $orderid cannot be cancelled.")
    }

    @PostMapping("/process")
    fun processOrder(): Any?{
        return ordersvc.processOrder() ?: throw RuntimeException("No Orders to process")
    }
}