package com.example.appbychatgpt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StockAdapter(private var stocks: List<Stock>) :
  RecyclerView.Adapter<StockAdapter.StockViewHolder>() {

  class StockViewHolder(val view: View) : RecyclerView.ViewHolder(view)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.stock_item, parent, false)
    return StockViewHolder(view)
  }

  override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
    val stock = stocks[position]
    val textView = holder.view.findViewById<TextView>(R.id.text_view)
    textView.text = "${stock.name} - ${stock.price}"
  }

  override fun getItemCount(): Int {
    return stocks.size
  }

  fun updateStocks(stocks: List<Stock>) {
    this.stocks = stocks
    notifyDataSetChanged()
  }
}
