package com.example.khatabook.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.khatabook.R
import com.example.khatabook.adapter.SpinnerAdapter
import com.example.khatabook.databinding.ActivityAddEntryBinding
import com.example.khatabook.helper.BookHelper.Companion.initBookDB
import com.example.khatabook.model.ProductEntity
import com.example.khatabook.model.UserEntity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddEntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEntryBinding
    private var list = mutableListOf<UserEntity>()
    private var payment:Int=0
    var selectUserId:Int=0

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
        setPaymentStatus()

        binding.spinner2.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectUserId = list[position].userId
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@AddEntryActivity, "Nothing Select", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setSpinner()
    {
        list = initBookDB(this).userDAO().userRead()
        val spinnerAdapter = SpinnerAdapter(list)
        binding.spinner2.adapter = spinnerAdapter

        binding.entryBackBtn.setOnClickListener {
            finish()
        }
    }

    private fun insertEntry()
    {
        binding.addEntrySubmitBtn.setOnClickListener{

            val proName = binding.setProductName.text.toString()
            val proQuantity = binding.setProductQuantity.text.toString()
            val proPrice = binding.setProductPrice.text.toString()
            val totalAmount = proPrice.toInt() * proQuantity.toInt()
            binding.setTotalAmount.setText(totalAmount.toString())
            val collectionDate = binding.setCollectionDate.text.toString()

            val calendar1 = Calendar.getInstance()
            val format = "dd/MM/yyyy"
            val dateFormat = SimpleDateFormat(format,Locale.US)
            val entryDate = dateFormat.format(calendar1.time)

            setPaymentStatus()

            val productEntity = ProductEntity(proName = proName, selectUserId = selectUserId, proQuantity = proQuantity, proPrice = proPrice, proTotalAmount = totalAmount.toString(), payStatus = payment, collectionDate = collectionDate, entryDate = entryDate)

            initBookDB(this).userDAO().productInsert(productEntity)

            finish()
        }
    }

    private fun setPaymentStatus()
    {
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->

            when(checkedId)
            {
                R.id.radioDebit -> {
                    payment = 1
                    binding.chooseDateStatusCard.visibility = View.GONE
                }
                R.id.radioCredit -> {
                    payment = 2
                    binding.chooseDateStatusCard.visibility = View.VISIBLE
                    datePicker()
                }
            }
        }
    }

    private fun datePicker()
    {
        val calendar = Calendar.getInstance()

        val datePickerDialog = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,month)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)

            val format = "dd/MM/yyyy"
            val dateFormat = SimpleDateFormat(format,Locale.US)
            binding.setCollectionDate.text = dateFormat.format(calendar.time)

        }

        binding.chooseDateStatusCard.setOnClickListener {
            val datePickerDialog2 = DatePickerDialog(this,datePickerDialog,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))

            datePickerDialog2.datePicker.minDate = calendar.timeInMillis
            datePickerDialog2.show()
        }
    }
}