package com.example.khatabook.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khatabook.R
import com.example.khatabook.activity.AddEntryActivity
import com.example.khatabook.activity.AddUserActivity
import com.example.khatabook.adapter.ProductEntryAdapter
import com.example.khatabook.databinding.ActivityMainBinding
import com.example.khatabook.databinding.FragmentHomeBinding
import com.example.khatabook.helper.BookHelper.Companion.initBookDB
import com.example.khatabook.model.ProductEntity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    var productEntryAdapter:ProductEntryAdapter?=null
    var entryList = mutableListOf<ProductEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        initIntentOnClick()
        setTransactionAdapter()

        return binding.root
    }

    private fun initIntentOnClick()
    {
        binding.addUserBtn.setOnClickListener {
            val intent = Intent(context,AddUserActivity::class.java)
            startActivity(intent)
        }

        binding.addEntryBtn.setOnClickListener {
            val intent = Intent(context,AddEntryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setTransactionAdapter()
    {
        productEntryAdapter = ProductEntryAdapter(entryList)
        binding.transactionRecyclerView.adapter = productEntryAdapter
    }

    override fun onResume() {
        entryList = initBookDB(requireContext()).userDAO().productRead()
        productEntryAdapter!!.dataChangeEntry(entryList)
        super.onResume()
    }

}