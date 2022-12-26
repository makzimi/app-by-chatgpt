package com.example.appbychatgpt

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlphaVantageAPI {
  companion object {
    const val BASE_URL = "https://www.alphavantage.co/"
    const val API_KEY = "YOUR_API_KEY_HERE"
  }

  @GET("query")
  fun getStockPrices(
    @Query("function") function: String = "GLOBAL_QUOTE",
    @Query("symbol") symbol: String,
    @Query("apikey") apiKey: String = API_KEY
  ): Call<StockResponse>
}