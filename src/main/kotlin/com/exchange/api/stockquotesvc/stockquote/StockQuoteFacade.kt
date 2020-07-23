package com.exchange.api.stockquotesvc.stockquote

import main.kotlin.com.exchange.api.stockquotesvc.tradeexchange.ITradeExchangeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class StockQuoteFacade @Autowired private constructor(
        stockQuoteService: IStockQuoteService,
        tradeExchangeService: ITradeExchangeService
) {
    private val stockQuoteService: IStockQuoteService
    private val tradeExchangeService: ITradeExchangeService
    fun lastTradedStockPriceInfo(ticker: String?, exchange: String?): StockQuoteDTO? {
        val companyDesc = tradeExchangeService.getTradedCompanyInfoByTickerName(ticker)
        val stockQuoteDTO: StockQuoteDTO? = stockQuoteService.pullStockQuoteByTickerId(ticker)
        stockQuoteDTO?.description = companyDesc
        return stockQuoteDTO
    }

    fun allTradedStockPriceInfo(): List<StockQuoteDTO> {
        val companydescList = tradeExchangeService.allTradedCompanyInfo
        val alltradedStockPrices: MutableList<StockQuoteDTO> = ArrayList()
        for (companyInfo in companydescList!!) {
            val stockQuoteDTO: StockQuoteDTO? = stockQuoteService.pullStockQuoteByTickerId(companyInfo!!.tickerSymbol)
            stockQuoteDTO?.description = companyInfo
            if (stockQuoteDTO != null) {
                alltradedStockPrices.add(stockQuoteDTO)
            }
        }
        return alltradedStockPrices
    }

    init {
        this.stockQuoteService = stockQuoteService
        this.tradeExchangeService = tradeExchangeService
    }
}