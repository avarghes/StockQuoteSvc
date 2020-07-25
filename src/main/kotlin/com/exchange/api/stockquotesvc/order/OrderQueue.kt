package com.exchange.api.stockquotesvc.order

import java.util.*

class OrderQueue(private val queue:Queue<Order?>) {

    fun addOrder(order:Order): Boolean = queue.add(order)

    fun getNextOrder() {
        if(queue.isNotEmpty()) {
            queue.remove();
        }
    }
}
