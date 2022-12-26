package com.example.appbychatgpt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

  private val stocks = mutableListOf<Stock>()

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

    val stockSymbols = listOf("AAPL", "MSFT", "GOOG", "FB", "AMZN", "JNJ", "XOM", "V", "PG", "JPM")

    for (symbol in stockSymbols) {
      Thread {
        val stockResponse = alphaVantageAPI.getStockPrices(symbol = symbol).execute().body()
        if (stockResponse?.stock != null) {
          stocks.add(stockResponse.stock)
          runOnUiThread {
            viewAdapter.updateStocks(stocks)
          }
        }
      }.start()
    }
  }
}