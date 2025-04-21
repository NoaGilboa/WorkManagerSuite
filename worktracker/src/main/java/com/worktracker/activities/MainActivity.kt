package com.worktracker.activities

import androidx.recyclerview.widget.RecyclerView
import com.example.common.activities.MainBaseActivity
import com.example.common.models.Worker
import com.worktracker.adapters.WorkerAdapter
import com.worktracker.dialogs.AddWorkerDialog

class MainActivity : MainBaseActivity() {

    private val workerList = mutableListOf<Worker>()
    private lateinit var adapter: WorkerAdapter

    override fun getTitleText(): String = "טבלת שעות עבודה"

    override fun onAddClicked() {
        AddWorkerDialog(this) { newWorker ->
            val workerWithId = newWorker.copy(id = workerList.size + 1)
            workerList.add(workerWithId)
            adapter.notifyItemInserted(workerList.lastIndex)
        }.show()

    }


    override fun onSummaryClicked() {
        SummaryActivity.start(this, workerList)
    }

    override fun getRecyclerViewAdapter(): RecyclerView.Adapter<*> {
        adapter = WorkerAdapter(workerList)
        return adapter
    }
}
