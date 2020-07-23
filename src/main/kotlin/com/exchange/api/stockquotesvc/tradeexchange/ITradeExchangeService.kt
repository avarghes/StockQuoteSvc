package com.exchange.api.stockquotesvc.tradeexchange

interface ITradeExchangeService {
    fun getTradedCompanyInfoByTickerName(ticker: String?): CompanyDescription?
    val allTradedCompanyInfo: List<CompanyDescription?>?
}