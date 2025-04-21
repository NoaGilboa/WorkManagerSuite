package com.worktracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.models.Worker
import com.example.workmanagersuite.R

class WorkerAdapter(private val workers: List<Worker>) : RecyclerView.Adapter<WorkerAdapter.WorkerViewHolder>() {

    class WorkerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val lblIndex: TextView = view.findViewById(R.id.lblIndex)
        val lblDate: TextView = view.findViewById(R.id.lblDate)
        val lblDay: TextView = view.findViewById(R.id.lblDay)
        val lblStartTime: TextView = view.findViewById(R.id.lblStartTime)
        val lblEndTime: TextView = view.findViewById(R.id.lblEndTime)
        val lblTotalHours: TextView = view.findViewById(R.id.lblTotalHours)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_worker, parent, false)
        return WorkerViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        val worker = workers[position]
        holder.lblIndex.text = (position + 1).toString()
        holder.lblDate.text = worker.date
        holder.lblDay.text = worker.day
        holder.lblStartTime.text = worker.startTime
        holder.lblEndTime.text = worker.endTime
        holder.lblTotalHours.text = "%.2f".format(worker.totalHours)
    }

    override fun getItemCount(): Int = workers.size
}