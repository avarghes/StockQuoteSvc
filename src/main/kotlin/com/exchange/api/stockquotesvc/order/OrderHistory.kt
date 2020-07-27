package com.exchange.api.stockquotesvc.order

class OrderHistory(val proccessed: HashSet<Order>) {

    fun addOrderHistory(order: Order?) {
        if (order != null)
            proccessed.add(order);
    }

    fun getOrderById(orderId: String): Order? {
        var order: Order? = null
        for (ordr in proccessed) {
            if (ordr.id == orderId) {
                order = ordr
            }
        }
        return order
    }
}