package com.example.khatabook.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.khatabook.R
import com.example.khatabook.databinding.EntryTransactionLayoutBinding
import com.example.khatabook.model.ProductEntity

class ProductEntryAdapter(private var entryList:MutableList<ProductEntity>) : Adapter<ProductEntryAdapter.ProEntryViewHolder>() {

    class ProEntryViewHolder(itemView: View) : ViewHolder(itemView)
    {
        val pBinding = EntryTransactionLayoutBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProEntryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.entry_transaction_layout,parent,false)
        return ProEntryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return entryList.size
    }

    override fun onBindViewHolder(holder: ProEntryViewHolder, position: Int) {
        holder.pBinding.setRvProName.text = entryList[position].proName
        holder.pBinding.setRvProQuantity.text = entryList[position].proQuantity
        holder.pBinding.setRvProPrice.text = entryList[position].proPrice
        holder.pBinding.setRvTotalAmount.text = entryList[position].proTotalAmount
    }

    @SuppressLint("NotifyDataSetChanged")
    fun dataChangeEntry(list: MutableList<ProductEntity>)
    {
        entryList = list
        notifyDataSetChanged()
    }
}