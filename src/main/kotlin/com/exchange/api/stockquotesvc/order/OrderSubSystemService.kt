package com.exchange.api.stockquotesvc.order

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrderSubSystemService(@Autowired val orderProcess: IOrderProcessingStrategy, @Autowired val orderQueue: OrderQueue, @Autowired val orderHistory: OrderHistory) {
    fun processOrder() : OrderResponse?{
        val order: Order? = orderQueue.getNextOrder()
        var response: OrderResponse? = null

        if (order != null) {
            orderProcess.proccess(order)
            orderHistory.addOrderHistory(order)
            response = OrderResponse(orderid = order.id,
                    scripName = order.scrip,orderType = order.type,
                    status = order.status,quantity = order.quantity,
                    triggerPrice = order.triggerPrice,
                    executedPrice = order.executedPrice)
        }


        return response
    }

    fun findOrder(orderid: String): Order? {
        val order: Order? = orderHistory.getOrderById(orderid)

        return order
    }

    fun createOrder(orderRequest: OrderRequest): OrderResponse {
        val order: Order = Order(id = generateOrderId(), scrip = orderRequest.scripName?:"NA", quantity = orderRequest.quantity
                , triggerPrice = orderRequest.triggerPrice, status = OrderStatus.ACCEPTED)

        orderQueue.addOrder(order)

        return OrderResponse(orderid = order.id,
                scripName = order.scrip, triggerPrice = order.triggerPrice ?: 0.00f,
                status = order.status ?: OrderStatus.CANCELLED,
                quantity = order.quantity ?: 0,
                orderType = order.type ?: OrderType.BUY
        )
    }

    fun cancelOrder(orderId: String): OrderResponse? {
        val order: Order = Order(id = orderId, scrip = "NONE")
        val status: Boolean = orderQueue.removeOrder(order)

        if(status) return OrderResponse(orderid = orderId, status = OrderStatus.CANCELLED)
        else return null
    }

    fun orderHistory(orderId: String): OrderResponse? {
        val order: Order? = orderHistory.getOrderById(orderId)
        var resp: OrderResponse? = null
        if (order != null) {
            resp = OrderResponse(orderid = order.id,
                    scripName = order.scrip, triggerPrice = order.triggerPrice ?: 0.00f,
                    status = order.status ?: OrderStatus.CANCELLED,
                    quantity = order.quantity ?: 0,
                    orderType = order.type ?: OrderType.BUY)
        }

        return resp
    }
}