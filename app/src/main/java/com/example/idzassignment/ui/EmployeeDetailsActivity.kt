package com.example.idzassignment.ui

import android.os.Bundle
import com.example.idzassignment.base.BaseActivity
import com.example.idzassignment.databinding.ActivityEmployeeDetailsBinding
import com.example.idzassignment.model.Employee
import com.example.idzassignment.utils.stringTrimmer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeDetailsActivity : BaseActivity<ActivityEmployeeDetailsBinding>() {
    override fun getActivityBinding(): ActivityEmployeeDetailsBinding =
        ActivityEmployeeDetailsBinding.inflate(layoutInflater)

    override fun activityStarted(savedInstanceState: Bundle?) {
        val employee = intent.getParcelableExtra<Employee>("employee")
        binding.apply {
            employee?.let {
                tvEmployeeName.text = it.name.stringTrimmer()
                tvEmployeeAge.text = it.age.stringTrimmer()
                tvEmployeeSalary.text = it.salary.stringTrimmer()
            }
            ivBack.setOnClickListener {
                finish()
            }
        }
    }
}