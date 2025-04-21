package com.example.common.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mylibrary.R

abstract class SummaryBaseActivity : AppCompatActivity() {

    abstract fun getTitleText(): String
    abstract fun getSummaryText(): String
    abstract fun onExportClicked()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_base)

        val titleText: TextView = findViewById(R.id.lbl_summary_title)
        val summaryText: TextView = findViewById(R.id.lbl_summary_text)
        val btnExport: Button = findViewById(R.id.btn_export_pdf)

        titleText.text = getTitleText()
        summaryText.text = getSummaryText()

        btnExport.setOnClickListener { onExportClicked() }
    }
}