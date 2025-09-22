package com.example.pocketpilot.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pocketpilot.Utils
import com.example.pocketpilot.data.ExpenseDatabase
import com.example.pocketpilot.data.dao.ExpenseDao
import com.example.pocketpilot.data.model.ExpenseSummary
import com.github.mikephil.charting.data.Entry

class StatsViewModel(val dao: ExpenseDao) : ViewModel() {
    val entries = dao.getAllExpensesByDate()
    val topEntries = dao.getTotExpenses()

    fun getEntriesForChart(entries: List<ExpenseSummary>): List<Entry> {
        val list = ArrayList<Entry>() // mutableListOf
        for (entry in entries) {
            val formattedDate = Utils.getMillisFromDate(entry.date)
            list.add(Entry(formattedDate.toFloat(), entry.totalAmount.toFloat()))
        }
        return list
    }

}

class StatsViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatsViewModel::class.java)) {
            val dao = ExpenseDatabase.getDatabase(context).expenseDao()
            @Suppress("UNCHECKED_CAST")
            return StatsViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}