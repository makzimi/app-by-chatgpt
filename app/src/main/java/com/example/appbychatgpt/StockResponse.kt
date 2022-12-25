package com.example.appbychatgpt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StockResponse {
  @SerializedName("Global Quote")
  @Expose
  private val stock: Stock? = null

  fun getStock(): Stock {
    return stock!!
  }
}