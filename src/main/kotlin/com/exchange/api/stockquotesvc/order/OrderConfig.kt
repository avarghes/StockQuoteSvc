package com.exchange.api.stockquotesvc.order

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import kotlin.collections.HashSet

@Configuration
class OrderConfig {

    @Value("\${order.queue.size}")
    var queueSize: Int = 0

    @Bean
    fun getOrderQueue(): OrderQueue {
        return OrderQueue(getQueue(), queueSize)
    }

    fun getQueue(): Queue<Order> = LinkedList<Order>()

    @Bean
    fun getOrderHistory(): OrderHistory{
        return OrderHistory(getOrderSet())
    }

    fun getOrderSet(): HashSet<Order> = HashSet<Order>()

    @Bean
    fun getOrderProcessStrategy(): IOrderProcessingStrategy{
       return SimpleOrderProcessStrategy()
    }
}