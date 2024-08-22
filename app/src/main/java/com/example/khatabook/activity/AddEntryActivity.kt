package com.example.khatabook.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.khatabook.R
import com.example.khatabook.adapter.SpinnerAdapter
import com.example.khatabook.databinding.ActivityAddEntryBinding
import com.example.khatabook.helper.BookHelper.Companion.initBookDB
import com.example.khatabook.model.BookEntity
import com.example.khatabook.model.ProductEntity

class AddEntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEntryBinding
    private var list = mutableListOf<BookEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSpinner()
        insertEntry()
    }

    private fun setSpinner()
    {
        list = initBookDB(this).userDAO().userRead()
        val spinnerAdapter = SpinnerAdapter(list)
        binding.spinner2.adapter = spinnerAdapter
    }

    private fun insertEntry()
    {
        binding.addEntrySubmitBtn.setOnClickListener{

            val proName = binding.setProductName.text.toString()
            val proQuantity = binding.setProductQuantity.text.toString()
            val proPrice = binding.setProductPrice.text.toString()
            val totalAmount = binding.setTotalAmount.text.toString()

            val productEntity = ProductEntity(proName = proName, proQuantity = proQuantity, proPrice = proPrice, proTotalAmount = totalAmount)

            initBookDB(this).userDAO().productInsert(productEntity)
        }
    }
}