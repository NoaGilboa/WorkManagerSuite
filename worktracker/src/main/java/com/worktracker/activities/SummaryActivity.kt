package com.worktracker.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.common.activities.SummaryBaseActivity
import com.example.common.models.Worker
import com.example.common.utils.PdfExporter

class SummaryActivity : SummaryBaseActivity() {

    private lateinit var workers: List<Worker>

    override fun getTitleText(): String = "סיכום חודשי"

    override fun getSummaryText(): String {
        val totalHours = workers.sumOf { it.totalHours.toDouble() }.toFloat()
        val averageHours = if (workers.isNotEmpty()) totalHours / workers.size else 0f

        return "סה\"כ שעות: %.2f\nממוצע ליום: %.2f".format(totalHours, averageHours)
    }

    override fun onExportClicked() {
        val totalHours = workers.sumOf { it.totalHours.toDouble() }.toFloat()
        val averageHours = if (workers.isNotEmpty()) totalHours / workers.size else 0f
        val content = "סיכום חודשי לעובד:\nסה\"כ שעות: %.2f\nממוצע ליום: %.2f".format(totalHours, averageHours)

        PdfExporter.exportTextToPdf(this, "worker_summary", content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        workers = intent.getSerializableExtra(EXTRA_WORKERS) as? List<Worker> ?: emptyList()
        super.onCreate(savedInstanceState)
    }

    companion object {
        private const val EXTRA_WORKERS = "EXTRA_WORKERS"

        fun start(context: Context, workers: List<Worker>) {
            val intent = Intent(context, SummaryActivity::class.java)
            intent.putExtra(EXTRA_WORKERS, ArrayList(workers))
            context.startActivity(intent)
        }
    }
}
