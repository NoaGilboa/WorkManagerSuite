package com.example.common.utils

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object PdfExporter {

    fun exportTextToPdf(context: Context, fileName: String, content: String) {
        val document = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create()
        val page = document.startPage(pageInfo)

        val canvas: Canvas = page.canvas
        val paint = Paint()
        paint.textSize = 14f

        val lines = content.split("\n")
        var y = 40f
        for (line in lines) {
            canvas.drawText(line, 40f, y, paint)
            y += 20f
        }

        document.finishPage(page)

        val dir = File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "PDFs")
        if (!dir.exists()) dir.mkdirs()
        val file = File(dir, "$fileName.pdf")

        try {
            document.writeTo(FileOutputStream(file))
            Toast.makeText(context, "PDF נוצר: ${file.name}", Toast.LENGTH_SHORT).show()
            sharePdf(context, file)
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(context, "שגיאה בשמירת PDF", Toast.LENGTH_SHORT).show()
        } finally {
            document.close()
        }
    }

    private fun sharePdf(context: Context, file: File) {
        val uri: Uri = FileProvider.getUriForFile(
            context,
            context.packageName + ".fileprovider",
            file
        )

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "application/pdf"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        context.startActivity(Intent.createChooser(shareIntent, "שיתוף PDF"))
    }
}