package com.exchange.api.stockquotesvc.tradeexchange

import java.util.*
import kotlin.collections.HashMap
/*import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.set*/

class TradeExchange() {
    var stocksTradedOnExchange: MutableMap<String, TradedCompanyDescription?>? = null
    var exchangeName: String? = null

    constructor(exchangeName: String?) : this() {
        this.exchangeName = exchangeName
    }

    fun addTicker(ticker: String, descriptionTraded: TradedCompanyDescription?) {
        stocksTradedOnExchange!![ticker] = descriptionTraded
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

    fun lookupTicker(ticker: String): TradedCompanyDescription? {
        return stocksTradedOnExchange!![ticker]
    }

    fun allTradedTicker(): List<TradedCompanyDescription?> {
        val tradedTickerList: MutableList<TradedCompanyDescription?> =
                ArrayList()
        stocksTradedOnExchange!!.forEach { (k: String?, v: TradedCompanyDescription?) ->
            tradedTickerList.add(v)
        }
        return tradedTickerList
    }

    init {
        stocksTradedOnExchange = HashMap()

        // Initialized to the default listed stocks
        var description = TradedCompanyDescription("GOOG", "Alphabet Inc", "Search Engine Giant.")
        (stocksTradedOnExchange as HashMap<String, TradedCompanyDescription?>)[description.tickerSymbol] = description
        description = TradedCompanyDescription("APPLE", "Apple Inc", "Manufacturer of iPhones/Macs.")
        (stocksTradedOnExchange as HashMap<String, TradedCompanyDescription?>)[description.tickerSymbol] = description
        description = TradedCompanyDescription(
                "GE", "General Electric Inc",
                "Industrial Behmoth (Jet Engines/Heavy Electricals)"
        )
        (stocksTradedOnExchange as HashMap<String, TradedCompanyDescription?>)[description.tickerSymbol] = description
        description = TradedCompanyDescription("WALM", "Walmart Inc", "Retail Giant")
        (stocksTradedOnExchange as HashMap<String, TradedCompanyDescription?>)[description.tickerSymbol] = description
    }
}