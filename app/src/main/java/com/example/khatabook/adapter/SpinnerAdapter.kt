package com.example.khatabook.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Spinner
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.khatabook.R
import com.example.khatabook.databinding.SpinnerSampleLayoutBinding
import com.example.khatabook.model.BookEntity

class SpinnerAdapter(private var list:MutableList<BookEntity>) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.spinner_sample_layout,parent,false)
        val sBinding = SpinnerSampleLayoutBinding.bind(view)
        sBinding.setUserNameSpinner.text = list[position].userName
        sBinding.setFirstTxt.text = list[position].userName.first().toString()
        return sBinding.root
    }

}