package com.example.idzassignment.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.idzassignment.base.BaseActivity
import com.example.idzassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var employeeAdapter: EmployeeAdapter

    override fun getActivityBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun activityStarted(savedInstanceState: Bundle?) {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainViewModel.getEmployees()
        observers()
    }

    private fun observers() {
        mainViewModel.apply {
            employeeData.observe(this@MainActivity) { employeeData ->
                employeeData.let {
                    employeeAdapter = EmployeeAdapter(it) { employee ->
                        startActivity(
                            Intent(
                                this@MainActivity,
                                EmployeeDetailsActivity::class.java
                            ).apply {
                                putExtra("employee", employee)
                            })
                    }
                    binding.rvEmployeeList.adapter = employeeAdapter
                    binding.rvEmployeeList.addItemDecoration(
                        DividerItemDecoration(
                            this@MainActivity,
                            DividerItemDecoration.VERTICAL
                        )
                    )
                    employeeAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}