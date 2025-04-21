package com.example.common.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View

abstract class BaseAddItemDialog<T>(
    private val context: Context,
    private val layoutResId: Int,
    private val title: String,
    private val onItemCreated: (T) -> Unit
) {

    fun show() {
        val view = LayoutInflater.from(context).inflate(layoutResId, null)

        AlertDialog.Builder(context)
            .setTitle(title)
            .setView(view)
            .setPositiveButton("הוסף") { _, _ ->
                val item = buildItem(view)
                onItemCreated(item)
            }
            .setNegativeButton("ביטול", null)
            .show()
    }

    protected abstract fun buildItem(view: View): T
}
