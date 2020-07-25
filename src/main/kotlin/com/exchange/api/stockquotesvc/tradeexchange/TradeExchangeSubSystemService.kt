package com.exchange.api.stockquotesvc.tradeexchange

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TradeExchangeSubSystemService @Autowired constructor(private val tradeExchange: TradeExchange) :
        ITradeExchangeService {
    override fun getTradedCompanyInfoByTickerName(ticker: String?): TradedCompanyDescription? {
        return tradeExchange.lookupTicker(ticker!!)
    }

    override val allTradedTradedCompanyInfo: List<TradedCompanyDescription?>
        get() = tradeExchange.allTradedTicker()

    val exchangeName: String?
        get() = tradeExchange.exchangeName

}