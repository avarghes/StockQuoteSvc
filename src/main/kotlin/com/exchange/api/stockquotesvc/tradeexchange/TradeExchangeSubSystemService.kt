package com.exchange.api.stockquotesvc.tradeexchange

import main.kotlin.com.exchange.api.stockquotesvc.tradeexchange.ITradeExchangeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TradeExchangeSubSystemService @Autowired constructor(private val tradeExchange: TradeExchange) :
        ITradeExchangeService {
    override fun getTradedCompanyInfoByTickerName(ticker: String?): CompanyDescription? {
        return tradeExchange.lookupTicker(ticker!!)
    }

    override val allTradedCompanyInfo: List<CompanyDescription?>
        get() = tradeExchange.allTradedTicker()

    val exchangeName: String?
        get() = tradeExchange.exchangeName

}