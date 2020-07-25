package com.exchange.api.stockquotesvc.tradeexchange

interface ITradeExchangeService {
    fun getTradedCompanyInfoByTickerName(ticker: String?): TradedCompanyDescription?
    val allTradedTradedCompanyInfo: List<TradedCompanyDescription?>?
}