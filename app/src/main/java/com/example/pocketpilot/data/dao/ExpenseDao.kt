package com.example.pocketpilot.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pocketpilot.data.model.ExpenseEntity
import com.example.pocketpilot.data.model.ExpenseSummary
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Query("Select * from expenses_table")
    fun getAllExpenses(): Flow<List<ExpenseEntity>>

    @Query("Select * From expenses_table where type = 'Expense' Order by amount DESC LIMIT 5")
    fun getTotExpenses(): Flow<List<ExpenseEntity>>

    @Query("Select type, date, SUM(amount) AS totalAmount FROM expenses_table where type = :type GROUP BY type, date ORDER BY date")
    fun getAllExpensesByDate(type: String = "Expense"): Flow<List<ExpenseSummary>>

    @Insert
    suspend fun insertExpenses(expenseEntity: ExpenseEntity)

    @Delete
    suspend fun deleteExpenses(expenseEntity: ExpenseEntity)

    @Update
    suspend fun updateExpenses(expenseEntity: ExpenseEntity)

}