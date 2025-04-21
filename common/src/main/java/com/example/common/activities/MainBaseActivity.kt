package com.example.common.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.models.Employee
import com.example.mylibrary.R

abstract class MainBaseActivity : AppCompatActivity() {

    abstract fun getTitleText(): String
    abstract fun onAddClicked()
    abstract fun onSummaryClicked()
    abstract fun getRecyclerViewAdapter(): RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_base)

        val title: TextView = findViewById(R.id.title_text)
        val btnAdd: Button = findViewById(R.id.btn_add_entry)
        val btnSummary: Button = findViewById(R.id.btn_summary)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        title.text = getTitleText()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = getRecyclerViewAdapter()

        btnAdd.setOnClickListener { onAddClicked() }
        btnSummary.setOnClickListener { onSummaryClicked() }
    }
}