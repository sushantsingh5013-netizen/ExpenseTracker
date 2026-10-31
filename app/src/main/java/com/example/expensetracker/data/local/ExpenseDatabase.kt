package com.example.expensetracker.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.expensetracker.data.local.converters.BudgetConverters
import com.example.expensetracker.data.local.converters.TransactionConverters
import com.example.expensetracker.data.local.dao.BudgetDao
import com.example.expensetracker.data.local.dao.CategoryDao
import com.example.expensetracker.data.local.dao.TransactionDao
import com.example.expensetracker.data.local.entity.BudgetEntity
import com.example.expensetracker.data.local.entity.CategoryEntity
import com.example.expensetracker.data.local.entity.TransactionEntity

@Database(
    entities = [
        TransactionEntity::class,
        CategoryEntity::class,
        BudgetEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    BudgetConverters::class,
    TransactionConverters::class
)
abstract class ExpenseDatabase: RoomDatabase() {

    abstract fun transactionDao() : TransactionDao

    abstract fun categoryDao() : CategoryDao

    abstract fun budgetDao() : BudgetDao
}