package com.example.appbychatgpt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Stock {
  @SerializedName("01. symbol")
  @Expose
  val symbol: String? = null
  @SerializedName("02. open")
  @Expose
  val open: String? = null
  @SerializedName("03. high")
  @Expose
  val high: String? = null
  @SerializedName("04. low")
  @Expose
  val low: String? = null
  @SerializedName("05. price")
  @Expose
  val price: String? = null
  @SerializedName("06. volume")
  @Expose
  val volume: String? = null
  @SerializedName("07. latest trading day")
  @Expose
  val latestTradingDay: String? = null
  @SerializedName("08. previous close")
  @Expose
  val previousClose: String? = null
  @SerializedName("09. change")
  @Expose
  val change: String? = null
  @SerializedName("10. change percent")
  @Expose
  val changePercent: String? = null
}
