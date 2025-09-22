package com.example.pocketpilot.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pocketpilot.data.dao.ExpenseDao
import com.example.pocketpilot.data.model.ExpenseEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class ExpenseDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao

    companion object {
        const val DATABASE_NAME = "expense_database"

        @JvmStatic
        fun getDatabase(context: Context): ExpenseDatabase {
            return Room.databaseBuilder(
                context,
                ExpenseDatabase::class.java,
                DATABASE_NAME
            ).addCallback(object :
                RoomDatabase.Callback() {    // this callback is only for the testing purpose to check data is filled correctly or not., it will be removed later.
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
//                    initBasicData(context)
                }

                fun initBasicData(context: Context) {
                    CoroutineScope(Dispatchers.IO).launch {
                        val dao = getDatabase(context).expenseDao()
                        dao.insertExpenses(
                            ExpenseEntity(1, "Youtube", 4567.45, System.currentTimeMillis().toString(), "Youtube", "Income")
                        )
                        dao.insertExpenses(
                            ExpenseEntity(2, "Paypal", 2000.96, System.currentTimeMillis().toString(), "Paypal", "Income")
                        )
                        dao.insertExpenses(
                            ExpenseEntity(3, "Netflix", 1864.43, System.currentTimeMillis().toString(), "Netflix", "Expense")
                        )
                        dao.insertExpenses(
                            ExpenseEntity(4, "Starbucks", 398.8, System.currentTimeMillis().toString(), "Starbucks", "Expense")
                        )
                    }
                }
            })
                .build()
        }
    }

}