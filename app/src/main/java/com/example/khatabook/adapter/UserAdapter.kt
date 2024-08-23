package com.example.khatabook.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.khatabook.R
import com.example.khatabook.databinding.AddUserLayoutBinding
import com.example.khatabook.model.UserEntity

class UserAdapter(private var userList:MutableList<UserEntity>) : Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : ViewHolder(itemView){

        var binding = AddUserLayoutBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.add_user_layout,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.setUserName.text = userList[position].userName
        holder.binding.setUserMobile.text = userList[position].userMobile
        holder.binding.userBackground.setOnClickListener {

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun dataChange(list:MutableList<UserEntity>)
    {
        userList = list
        notifyDataSetChanged()
    }
}