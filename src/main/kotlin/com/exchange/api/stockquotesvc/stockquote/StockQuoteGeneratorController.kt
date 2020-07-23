package com.exchange.api.stockquotesvc.stockquote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StockQuoteGeneratorController @Autowired constructor(private val stockQuoteFacade: StockQuoteFacade) {

    @get:GetMapping("/api/v1/stockquotes")
    val stockQuotes: List<Any>
        get() = stockQuoteFacade.allTradedStockPriceInfo()

    @GetMapping("/api/v1/stockquote/{ticker}/{exchange}")
    fun getStockQuote(
        @PathVariable("ticker") tickerSymbol: String?,
        @PathVariable("exchange") exchange: String?
    ): StockQuoteDTO? {
        return stockQuoteFacade.lastTradedStockPriceInfo(tickerSymbol, exchange)
    }

}