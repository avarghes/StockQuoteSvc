package com.exchange.api.stockquotesvc.stockquote

import org.springframework.stereotype.Component

@Component
internal class StockQuoteSubSystemService : IStockQuoteService {
    override fun pullStockQuoteByTickerId(tickerId: String?): StockQuoteDTO {
        return RandomStockQuoteGenerator.generate(tickerId)
    }
}