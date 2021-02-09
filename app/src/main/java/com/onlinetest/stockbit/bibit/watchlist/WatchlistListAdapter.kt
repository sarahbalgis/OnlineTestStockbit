package com.onlinetest.stockbit.bibit.watchlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.onlinetest.stockbit.bibit.R
import com.onlinetest.stockbit.bibit.utils.Utils
import com.onlinetest.stockbit.bibit.databinding.WatchlistItemBinding

class WatchlistListAdapter: PagedListAdapter<CoinItem, WatchlistListAdapter.WatchlistViewHolder>(
object : DiffUtil.ItemCallback<CoinItem>(){
    override fun areItemsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
        return oldItem.coinInfo?.id == newItem.coinInfo?.id
    }

    override fun areContentsTheSame(oldItem: CoinItem, newItem: CoinItem): Boolean {
        return oldItem == newItem
    }

}) {

    class WatchlistViewHolder(val binding: WatchlistItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistViewHolder {
        val binding = WatchlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WatchlistViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WatchlistViewHolder, position: Int) {
        val item = getItem(position) as CoinItem
        holder.binding.nameView.text = item.coinInfo?.name
        holder.binding.fullnameView.text = item.coinInfo?.fullName
        holder.binding.priceView.text = Utils.printDecimalFormat(item.rawInfo?.usdCurrencyItem?.price?:0.0)
        holder.binding.changePerHourView.apply {
            val value = item.rawInfo?.usdCurrencyItem?.changeHour?:0.0
            text = if(value > 0) "+${Utils.printDecimalFormat(value)}" else Utils.printDecimalFormat(value)
            when {
                value < 0 -> {
                    setTextColor(ContextCompat.getColorStateList(context, R.color.red))
                }
                value == 0.0 -> {
                    setTextColor(ContextCompat.getColorStateList(context, R.color.black))
                }
                else -> {
                    setTextColor(ContextCompat.getColorStateList(context, R.color.green))
                }
            }
        }
        holder.binding.changePerHourInPercentView.apply {
            val value = item.rawInfo?.usdCurrencyItem?.changeHourPercent?:0.0
            text =  "("+if(value > 0) "+${Utils.printDecimalFormat(value)}%)" else Utils.printDecimalFormat(value)+"%)"
            when {
                value < 0.0 -> {
                    setTextColor(ContextCompat.getColorStateList(context, R.color.red))
                }
                value == 0.0 -> {
                    setTextColor(ContextCompat.getColorStateList(context, R.color.black))
                }
                else -> {
                    setTextColor(ContextCompat.getColorStateList(context, R.color.green))
                }
            }
        }
    }
}