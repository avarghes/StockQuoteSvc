package com.exchange.api.stockquotesvc.stockquote

import com.exchange.api.stockquotesvc.tradeexchange.TradedCompanyDescription
import java.time.LocalDate
import java.util.*

data class StockQuoteDTO(val openningPrice: Float = 0f,
                         val closingPrice: Float = 0f,
                         val listedExchange: String?,
                         val currency: Currency?,
                         val tradingDay: LocalDate?,
                         var descriptionTraded: TradedCompanyDescription? = null,
                         val ticker:String)