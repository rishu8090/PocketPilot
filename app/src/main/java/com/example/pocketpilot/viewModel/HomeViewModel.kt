package com.example.pocketpilot.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pocketpilot.R
import com.example.pocketpilot.Utils
import com.example.pocketpilot.data.ExpenseDatabase
import com.example.pocketpilot.data.dao.ExpenseDao
import com.example.pocketpilot.data.model.ExpenseEntity

class HomeViewModel(dao: ExpenseDao) : ViewModel() {
    val expenses = dao.getAllExpenses()
    fun getBalance(list: List<ExpenseEntity>): String {
        var balance = 0.0
        list.forEach {
            if (it.type == "Income") {
                balance += it.amount
            } else {
                balance -= it.amount
            }
        }
        return "₹ ${Utils.formatToDecimalValue(balance)}"
    }

    fun getTotalExpenses(list: List<ExpenseEntity>): String {
        var total = 0.0
        list.forEach {
            if (it.type == "Expense") {
                total -= it.amount
            }
        }
        return "₹ ${Utils.formatToDecimalValue(total)}"
    }

    fun getTotalIncome(list: List<ExpenseEntity>): String {
        var totalIncome = 0.0
        list.forEach {
            if (it.type == "Income") {
                totalIncome += it.amount
            }
        }
        return "₹ ${Utils.formatToDecimalValue(totalIncome)}"
    }


}

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val dao = ExpenseDatabase.getDatabase(context).expenseDao()
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}