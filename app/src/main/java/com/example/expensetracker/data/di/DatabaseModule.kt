package com.example.expensetracker.data.di

import android.content.Context
import androidx.room.Room
import com.example.expensetracker.data.local.ExpenseDatabase
import com.example.expensetracker.data.local.dao.BudgetDao
import com.example.expensetracker.data.local.dao.CategoryDao
import com.example.expensetracker.data.local.dao.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideExpenseDatabase(
        @ApplicationContext context : Context
    ) : ExpenseDatabase{
        return Room.databaseBuilder(
            context,
            ExpenseDatabase::class.java,
            "expense_database"
        ).build()
    }

    @Provides
    fun provideTransactionDao(
        database: ExpenseDatabase
    ): TransactionDao{
        return database.transactionDao()
    }

    @Provides
    fun provideCategoryDao(
        database: ExpenseDatabase
    ) : CategoryDao{
        return database.categoryDao()
    }

    @Provides
    fun provideBudgetDao(
        database : ExpenseDatabase
    ) : BudgetDao{
        return database.budgetDao()
    }
}