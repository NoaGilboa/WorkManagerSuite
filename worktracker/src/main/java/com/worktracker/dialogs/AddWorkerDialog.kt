package com.worktracker.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import com.example.common.dialogs.BaseAddItemDialog
import com.example.common.models.Worker
import com.example.workmanagersuite.R

class AddWorkerDialog(
    context: Context,
    onWorkerAdded: (Worker) -> Unit
) : BaseAddItemDialog<Worker>(context, R.layout.dialog_add_worker, "הוסף שעות עבודה", onWorkerAdded) {

    override fun buildItem(view: View): Worker {
        val date = view.findViewById<EditText>(R.id.etDate).text.toString()
        val day = view.findViewById<EditText>(R.id.etDay).text.toString()
        val startTime = view.findViewById<EditText>(R.id.etStartTime).text.toString()
        val endTime = view.findViewById<EditText>(R.id.etEndTime).text.toString()
        return Worker(0, date, day, startTime, endTime)
    }
}

