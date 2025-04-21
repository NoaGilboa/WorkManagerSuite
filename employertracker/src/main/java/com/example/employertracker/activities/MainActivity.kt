package com.example.employertracker.activities

import androidx.recyclerview.widget.RecyclerView
import com.example.employertracker.dialogs.AddEmployeeDialog
import com.example.common.activities.MainBaseActivity
import com.example.common.models.Employee
import com.example.employertracker.adapters.EmployeeAdapter

class MainActivity : MainBaseActivity() {

    private val employeeList = mutableListOf<Employee>()
    private lateinit var adapter: EmployeeAdapter

    override fun getTitleText(): String {
        return "טבלת עובדים"
    }

    override fun onAddClicked() {
        AddEmployeeDialog(this) { newEmployee ->
            val employeeWithId = newEmployee.copy(id = employeeList.size + 1)
            employeeList.add(employeeWithId)
            adapter.notifyItemInserted(employeeList.lastIndex)
        }.show()

    }


    override fun onSummaryClicked() {
        SummaryActivity.start(this, employeeList)
    }

    override fun getRecyclerViewAdapter(): RecyclerView.Adapter<*> {
        adapter = EmployeeAdapter(employeeList)
        return adapter
    }

}