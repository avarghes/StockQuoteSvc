package main.kotlin.com.exchange.api.stockquotesvc.tradeexchange

import com.exchange.api.stockquotesvc.tradeexchange.CompanyDescription

interface ITradeExchangeService {
    fun getTradedCompanyInfoByTickerName(ticker: String?): CompanyDescription?
    val allTradedCompanyInfo: List<CompanyDescription?>?
}