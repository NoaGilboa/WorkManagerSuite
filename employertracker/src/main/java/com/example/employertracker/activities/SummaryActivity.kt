package com.example.employertracker.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.common.activities.SummaryBaseActivity
import com.example.common.models.Employee
import com.example.common.utils.PdfExporter
import java.util.Locale

class SummaryActivity : SummaryBaseActivity() {

    private lateinit var employees: List<Employee>

    override fun getTitleText(): String = "סיכום עובדים לחודש"

    override fun getSummaryText(): String {
        val totalEmployees = employees.size
        val totalHours = employees.sumOf { it.monthlyHours.toDouble() }.toFloat()
        val totalSalary = employees.sumOf { it.monthlySalary.toDouble() }.toFloat()

        return "סה\"כ עובדים: $totalEmployees\nסה\"כ שעות: %.2f\nסה\"כ שכר: %.2f"
            .format(totalHours, totalSalary)
    }

    override fun onExportClicked() {
        val totalEmployees = employees.size
        val totalHours = employees.sumOf { it.monthlyHours.toDouble() }.toFloat()
        val totalSalary = employees.sumOf { it.monthlySalary.toDouble() }.toFloat()

        val content = String.format(
            Locale.US,
            "סיכום עובדים לחודש:\nסה\"כ עובדים: %d\nסה\"כ שעות: %.2f\nסה\"כ שכר: %.2f",
            totalEmployees, totalHours, totalSalary
        )

        PdfExporter.exportTextToPdf(this, "employer_summary", content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        employees = intent.getSerializableExtra(EXTRA_EMPLOYEES) as? List<Employee> ?: emptyList()
        super.onCreate(savedInstanceState)
    }

    companion object {
        private const val EXTRA_EMPLOYEES = "EXTRA_EMPLOYEES"

        fun start(context: Context, employees: List<Employee>) {
            val intent = Intent(context, SummaryActivity::class.java)
            intent.putExtra(EXTRA_EMPLOYEES, ArrayList(employees))
            context.startActivity(intent)
        }
    }
}