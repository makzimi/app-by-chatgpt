package com.example.appbychatgpt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Stock {
  @SerializedName("01. symbol")
  @Expose
  private val symbol: String? = null
  @SerializedName("02. open")
  @Expose
  private val open: String? = null
  @SerializedName("03. high")
  @Expose
  private val high: String? = null
  @SerializedName("04. low")
  @Expose
  private val low: String? = null
  @SerializedName("05. price")
  @Expose
  private val price: String? = null
  @SerializedName("06. volume")
  @Expose
  private val volume: String? = null
  @SerializedName("07. latest trading day")
  @Expose
  private val latestTradingDay: String? = null
  @SerializedName("08. previous close")
  @Expose
  private val previousClose: String? = null
  @SerializedName("09. change")
  @Expose
  private val change: String? = null
  @SerializedName("10. change percent")
  @Expose
  private val changePercent: String? = null

  fun getSymbol(): String {
    return symbol!!
  }

  fun getOpen(): String {
    return open!!
  }

  fun getHigh(): String {
    return high!!
  }

  fun getLow(): String {
    return low!!
  }

  fun getPrice(): String {
    return price!!
  }

  fun getVolume(): String {
    return volume!!
  }

  fun getLatestTradingDay(): String {
    return latestTradingDay!!
  }

  fun getPreviousClose(): String {
    return previousClose!!
  }

  fun getChange(): String {
    return change!!
  }

  fun getChangePercent(): String {
    return changePercent!!
  }
}
