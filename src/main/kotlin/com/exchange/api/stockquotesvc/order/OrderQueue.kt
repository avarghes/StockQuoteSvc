package com.exchange.api.stockquotesvc.order

import java.util.*

class OrderQueue(private val queue: Queue<Order>, private val maxsize: Int) {

    var size: Int = 0

    fun addOrder(order: Order) : Boolean {
        if (size == maxsize) {
            throw RuntimeException("Order Queue is Full..Try After some time.")
        }

        val success = queue.add(order)
        size++

        return success
    }

    fun getNextOrder(): Order? {
        if (queue.isEmpty()) {
            throw RuntimeException("No new orders to process.")
        }

        return queue.remove()
    }

    fun removeOrder(order: Order): Boolean{
       return queue.removeIf { it.id == order.id };
    }
}
