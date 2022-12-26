package com.example.appbychatgpt

import com.google.gson.annotations.SerializedName

data class StockResponse(
  @SerializedName("Global Quote")
  val stocks: List<Stock>
)