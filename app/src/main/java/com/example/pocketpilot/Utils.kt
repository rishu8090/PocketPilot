package com.example.pocketpilot

import com.example.pocketpilot.data.model.ExpenseEntity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {

    fun formatDateToHumanReadableForm(dateInMillis: Long): String {
        val dateFormater = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormater.format(dateInMillis)
    }

    fun formatDateForChart(dateInMillis: Long): String {
        val dateFormater = SimpleDateFormat("dd/MM", Locale.getDefault())
        return dateFormater.format(dateInMillis)
    }

    fun formatToDecimalValue(d: Double): String {
        return String.format("%.2f", d)
    }

    fun formatDayMonth(dateInMillis: Long): String {
        val dateFormatter = SimpleDateFormat("dd/MM", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }

    fun getMillisFromDate(date: String): Long {
        return getMilliFromDate(date)
    }

    fun getMilliFromDate(dateFormat: String?): Long {
        var date = Date()
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        try {
            date = formatter.parse(dateFormat)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        println("Today is $date")
        return date.time
    }

    fun getItemIcon(item: ExpenseEntity): Int {
        if (item.category == "Paypal") {
            return R.drawable.ic_paypal
        } else if (item.category == "Netflix") {
            return R.drawable.ic_netflix
        } else if (item.category == "Starbucks") {
            return R.drawable.ic_starbucks
        } else if (item.category == "Youtube") {
            return R.drawable.ic_youtube
        }
        return R.drawable.ic_upwork
    }
}