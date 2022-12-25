package com.example.appbychatgpt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StockResponse {
  @SerializedName("Global Quote")
  @Expose
  val stock: Stock? = null
}