package com.example.appbychatgpt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

  private lateinit var textView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Initialize the TextView
    textView = findViewById(R.id.text_view)

    // Create a Retrofit instance
    val retrofit = Retrofit.Builder()
      .baseUrl(AlphaVantageAPI.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    // Create an AlphaVantageAPI instance
    val alphaVantageAPI = retrofit.create(AlphaVantageAPI::class.java)

    // Make a request to the Alpha Vantage API to get stock prices
    val call = alphaVantageAPI.getStockPrices(symbol = "AAPL")
    call.enqueue(object : Callback<StockResponse> {
      override fun onResponse(call: Call<StockResponse>, response: Response<StockResponse>) {
        // Check if the request was successful
        if (response.isSuccessful) {
          // Get the stock price from the response
          val stock = response.body()!!.stock
          if (stock != null) {
            val price = stock.price

            // Update the TextView with the stock price
            textView.text = price
          } else {
            // Handle the case where the stock field is null
            textView.text = "Error: stock field is null"
          }
        } else {
          // Print the error message if the request was not successful
          textView.text = response.errorBody().toString()
        }
      }

      override fun onFailure(call: Call<StockResponse>, t: Throwable) {
        // Handle the failure
        textView.text = t.message
      }
    })
  }
}