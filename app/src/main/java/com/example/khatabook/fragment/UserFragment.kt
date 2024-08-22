package com.example.khatabook.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khatabook.R
import com.example.khatabook.adapter.UserAdapter
import com.example.khatabook.databinding.FragmentUserBinding
import com.example.khatabook.helper.BookHelper.Companion.initBookDB
import com.example.khatabook.model.BookEntity

class UserFragment(private var context1: Context) : Fragment() {

    private var userAdapter:UserAdapter?=null
    private var userList = mutableListOf<BookEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentUserBinding.inflate(layoutInflater)

        userAdapter = UserAdapter(userList)
        binding.userRecyclerView.adapter = userAdapter

        return binding.root
    }

    override fun onResume() {
        val db = initBookDB(context1)
        userList = db.userDAO().userRead()
        userAdapter!!.dataChange(userList)
        super.onResume()
    }

}