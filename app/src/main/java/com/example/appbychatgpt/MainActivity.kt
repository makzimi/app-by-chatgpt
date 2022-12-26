package com.example.appbychatgpt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

  private lateinit var recyclerView: RecyclerView
  private lateinit var viewAdapter: StockAdapter
  private lateinit var viewManager: RecyclerView.LayoutManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    viewManager = LinearLayoutManager(this)
    viewAdapter = StockAdapter(emptyList())

    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
      setHasFixedSize(true)
      layoutManager = viewManager
      adapter = viewAdapter
    }

    // Create a Retrofit instance
    val retrofit = Retrofit.Builder()
      .baseUrl(AlphaVantageAPI.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    // Create an AlphaVantageAPI instance
    val alphaVantageAPI = retrofit.create(AlphaVantageAPI::class.java)

    // Make a request to the Alpha Vantage API to get stock prices
    alphaVantageAPI.getTopStocks().enqueue(object : Callback<StockResponse> {
      override fun onResponse(call: Call<StockResponse>, response: Response<StockResponse>) {
        if (response.isSuccessful) {
          viewAdapter.updateStocks(response.body()!!.stocks)
        } else {
          // handle error
        }
      }

      override fun onFailure(call: Call<StockResponse>, t: Throwable) {
        // handle failure
      }
    })
  }
}