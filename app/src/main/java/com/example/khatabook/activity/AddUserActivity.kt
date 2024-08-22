package com.example.khatabook.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.khatabook.R
import com.example.khatabook.databinding.ActivityAddUserBinding
import com.example.khatabook.helper.BookHelper
import com.example.khatabook.helper.BookHelper.Companion.initBookDB
import com.example.khatabook.model.BookEntity

class AddUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        insertUser()
        onBackClick()
    }

    private fun onBackClick()
    {
        binding.userBackBtn.setOnClickListener {
            finish()
        }
    }

    private fun insertUser()
    {
        binding.userSubmitBtn.setOnClickListener {

            val userName = binding.userNameEdt.text.toString()
            val userMobile = binding.userMobileEdt.text.toString()

            val model = BookEntity(userName = userName, userMobile = userMobile)

            initBookDB(this).userDAO().userInsert(model)
        }
    }
}