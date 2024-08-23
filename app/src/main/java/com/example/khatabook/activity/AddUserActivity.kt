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
import com.example.khatabook.model.UserEntity

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
            val userFlat = binding.setUserFlatNo.text.toString()
            val userArea = binding.setUserArea.text.toString()
            val userPin = binding.setUserPincode.text.toString()
            val userCity = binding.setUserCity.text.toString()
            val userState = binding.setUserState.text.toString()

            if(userName.isEmpty())
            {
                binding.nameLayout.isErrorEnabled = true
                binding.nameLayout.error = "User's Name Required"
            }
            else if(userMobile.isEmpty())
            {
                binding.mobileLayout.isErrorEnabled = true
                binding.mobileLayout.error = "User's Mobile No. Required"
            }
            else
            {
                binding.nameLayout.isErrorEnabled = false
                binding.mobileLayout.isErrorEnabled = false

                val model = UserEntity(userName = userName, userMobile = userMobile, userFlat = userFlat, userArea = userArea, userPin = userPin, userCity = userCity, userState = userState)
                initBookDB(this).userDAO().userInsert(model)

                finish()
            }

        }
    }
}