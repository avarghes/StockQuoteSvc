package com.exchange.api.stockquotesvc.order

import java.time.LocalDate

class SimpleOrderProcessStrategy : IOrderProcessingStrategy{
    override fun proccess(order: Order){
            println("Processing the Order")
            println(order.toString())
            order.createdDate = LocalDate.now()
            order.processedDate = LocalDate.now()
            order.status = OrderStatus.EXECUTED
    }
}