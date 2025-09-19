package com.example.pocketpilot

import java.text.SimpleDateFormat
import java.util.Locale

object Utils {

    fun formatDateToHumanReadableForm(dateInMillis: Long): String {
        val dateFormater = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormater.format(dateInMillis)
    }

    fun formatToDecimalValue(d: Double): String{
        return String.format("%.2f", d)
    }
}