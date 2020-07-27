package com.exchange.api.stockquotesvc.stockquote

import com.exchange.api.stockquotesvc.tradeexchange.ITradeExchangeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class StockQuoteFacade @Autowired private constructor(
        private val stockQuoteService: IStockQuoteService,
        private val tradeExchangeService: ITradeExchangeService
) {
    fun lastTradedStockPriceInfo(ticker: String, exchange: String): StockQuoteDTO? {
        val companyDesc = tradeExchangeService.getTradedCompanyInfoByTickerName(ticker)
        val stockQuoteDTO: StockQuoteDTO? = stockQuoteService.pullStockQuoteByTickerId(ticker)
        stockQuoteDTO?.descriptionTraded = companyDesc
        return stockQuoteDTO
    }

    fun allTradedStockPriceInfo(): List<StockQuoteDTO> {
        val companydescList = tradeExchangeService.allTradedTradedCompanyInfo
        val alltradedStockPrices: MutableList<StockQuoteDTO> = ArrayList()
        for (companyInfo in companydescList!!) {
            val stockQuoteDTO: StockQuoteDTO? = stockQuoteService.pullStockQuoteByTickerId(companyInfo!!.tickerSymbol)
            stockQuoteDTO?.descriptionTraded = companyInfo
            if (stockQuoteDTO != null) {
                alltradedStockPrices.add(stockQuoteDTO)
            }
        }
        return alltradedStockPrices
    }

}