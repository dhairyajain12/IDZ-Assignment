package com.example.idzassignment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idzassignment.R
import com.example.idzassignment.databinding.ItemEmployeeInfoBinding
import com.example.idzassignment.model.Employee
import com.example.idzassignment.model.EmployeesData
import com.example.idzassignment.utils.stringTrimmer

class EmployeeAdapter(
    private val employeeData: EmployeesData,
    private val onItemClicked: (Employee) -> Unit
) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    inner class EmployeeViewHolder(val binding: ItemEmployeeInfoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeAdapter.EmployeeViewHolder {
        val binding = ItemEmployeeInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeAdapter.EmployeeViewHolder, position: Int) {
        val employee = employeeData.employees[position]
        with(holder) {
            with(binding) {
                tvEmployeeName.text =
                    itemView.context.getString(
                        R.string.employee_name,
                        employee.name.stringTrimmer()
                    )
                tvEmployeeAge.text =
                    itemView.context.getString(R.string.employee_age, employee.age.stringTrimmer())
                tvEmployeeSalary.text =
                    itemView.context.getString(
                        R.string.employee_salary,
                        employee.salary.stringTrimmer()
                    )
                root.setOnClickListener {
                    onItemClicked(employee)
                }
            }
        }
    }

    override fun getItemCount(): Int = employeeData.employees.size
}