package com.exchange.api.stockquotesvc.order

interface IOrderProcessingStrategy {
    fun proccess(order: Order)
}