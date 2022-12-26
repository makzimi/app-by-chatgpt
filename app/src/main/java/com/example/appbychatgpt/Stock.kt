package com.example.appbychatgpt

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Stock(
  @SerializedName("01. symbol")
  val name: String,
  @SerializedName("05. price")
  val price: String
)
