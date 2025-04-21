package com.example.employertracker.dialogs

import android.content.Context
import android.view.View
import android.widget.EditText
import com.example.common.dialogs.BaseAddItemDialog
import com.example.common.models.Employee
import com.example.employertracker.R

class AddEmployeeDialog(
    context: Context,
    onEmployeeAdded: (Employee) -> Unit
) : BaseAddItemDialog<Employee>(context, R.layout.dialog_add_employee, "הוסף עובד חדש", onEmployeeAdded) {

    override fun buildItem(view: View): Employee {
        val firstName = view.findViewById<EditText>(R.id.etFirstName).text.toString()
        val lastName = view.findViewById<EditText>(R.id.etLastName).text.toString()
        val idNumber = view.findViewById<EditText>(R.id.etIdNumber).text.toString()
        val hours = view.findViewById<EditText>(R.id.etMonthlyHours).text.toString().toFloatOrNull() ?: 0f
        val wage = view.findViewById<EditText>(R.id.etHourlyWage).text.toString().toFloatOrNull() ?: 0f

        return Employee(0, firstName, lastName, idNumber, hours, wage)
    }
}