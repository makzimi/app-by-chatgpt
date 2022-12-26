package com.example.appbychatgpt

import retrofit2.Call
import retrofit2.http.GET

interface AlphaVantageAPI {
  companion object {
    const val BASE_URL = "https://www.alphavantage.co/"
    const val API_KEY = "YOUR_API_KEY_HERE"
  }


  @GET("/query?function=TOP_100")
  fun getTopStocks(): Call<StockResponse>
}