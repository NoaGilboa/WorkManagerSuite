package com.example.employertracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.models.Employee
import com.example.employertracker.R

class EmployeeAdapter(private val employees: List<Employee>) : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lblIndex: TextView = view.findViewById(R.id.lblIndex)
        val lblId: TextView = view.findViewById(R.id.lblId)
        val lblFirstName: TextView = view.findViewById(R.id.lblFirstName)
        val lblLastName: TextView = view.findViewById(R.id.lblLastName)
        val lblHours: TextView = view.findViewById(R.id.lblHours)
        val lblWage: TextView = view.findViewById(R.id.lblWage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employees[position]
        holder.lblIndex.text = (position + 1).toString()
        holder.lblId.text = employee.identityNumber
        holder.lblFirstName.text = employee.firstName
        holder.lblLastName.text = employee.lastName
        holder.lblHours.text = "%.2f".format(employee.monthlyHours)
        holder.lblWage.text = "%.2f".format(employee.hourlyWage)
    }

    override fun getItemCount(): Int = employees.size
}
