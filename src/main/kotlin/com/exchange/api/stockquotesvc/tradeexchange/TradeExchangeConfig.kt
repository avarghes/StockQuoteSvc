package com.exchange.api.stockquotesvc.tradeexchange

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class TradeExchangeConfig {
    @Value("\${traded.exchange.name}")
    private val exchangeName: String? = null

    @get:Bean
    val tradeExchange: TradeExchange
        get() = TradeExchange("NASDAQ")
}