package com.exchange.api.stockquotesvc.stockquote

import com.exchange.api.stockquotesvc.tradeexchange.CompanyDescription
import java.io.Serializable
import java.time.LocalDate
import java.util.*

class StockQuoteDTO : Serializable {
    var openningPrice = 0f
    var closingPrice = 0f
    var listedExchange: String? = null
    var currency: Currency? = null
    var tradingDay: LocalDate? = null
    var description: CompanyDescription? = null

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 4692599796495022505L
    }
}