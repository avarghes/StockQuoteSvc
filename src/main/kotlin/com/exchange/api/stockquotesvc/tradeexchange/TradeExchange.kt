package com.exchange.api.stockquotesvc.tradeexchange

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.set

class TradeExchange() {
    var stocksTradedOnExchange: MutableMap<String, CompanyDescription?>? = null
    var exchangeName: String? = null

    constructor(exchangeName: String?) : this() {
        this.exchangeName = exchangeName
    }

    fun addTicker(ticker: String, description: CompanyDescription?) {
        stocksTradedOnExchange!![ticker] = description
    }

    fun removeTicker(ticker: String): Boolean {
        if (isTickerTraded(ticker)) {
            stocksTradedOnExchange!!.remove(ticker)
            return true
        }
        return false
    }

    fun isTickerTraded(ticker: String): Boolean {
        return stocksTradedOnExchange!![ticker] != null
    }

    fun lookupTicker(ticker: String): CompanyDescription? {
        return stocksTradedOnExchange!![ticker]
    }

    fun allTradedTicker(): List<CompanyDescription?> {
        val tradedTickerList: MutableList<CompanyDescription?> =
                ArrayList()
        stocksTradedOnExchange!!.forEach { (k: String?, v: CompanyDescription?) ->
            tradedTickerList.add(v)
        }
        return tradedTickerList
    }

    init {
        stocksTradedOnExchange = HashMap()

        // Initialized to the default listed stocks
        var description = CompanyDescription("GOOG", "Alphabet Inc", "Search Engine Giant.")
        (stocksTradedOnExchange as HashMap<String, CompanyDescription?>)[description.tickerSymbol] = description
        description = CompanyDescription("APPLE", "Apple Inc", "Manufacturer of iPhones/Macs.")
        (stocksTradedOnExchange as HashMap<String, CompanyDescription?>)[description.tickerSymbol] = description
        description = CompanyDescription(
                "GE", "General Electric Inc",
                "Industrial Behmoth (Jet Engines/Heavy Electricals)"
        )
        (stocksTradedOnExchange as HashMap<String, CompanyDescription?>)[description.tickerSymbol] = description
        description = CompanyDescription("WALM", "Walmart Inc", "Retail Giant")
        (stocksTradedOnExchange as HashMap<String, CompanyDescription?>)[description.tickerSymbol] = description
    }
}