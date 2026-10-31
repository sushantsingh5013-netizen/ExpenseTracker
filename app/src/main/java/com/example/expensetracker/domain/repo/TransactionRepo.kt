package com.example.expensetracker.domain.repo

import com.example.expensetracker.domain.model.TransactionType
import com.example.expensetracker.domain.model.Transactions
import kotlinx.coroutines.flow.Flow


interface TransactionRepo {
    suspend fun upsertTransaction(transaction : Transactions)

    suspend fun deleteTransaction(transaction : Transactions)

    suspend fun getTransactionById(id : String) : Transactions?

    fun getAllTransactions() : Flow<List<Transactions>>

    fun getTransactionByType(type : TransactionType) : Flow<List<Transactions>>

    fun getTotalByType(type : TransactionType) : Flow<Long>

    fun getTransactionsByCategory(categoryId : String) : Flow<List<Transactions>>

    fun getTransactionsByDateRange(startDate : Long, endDate : Long) : Flow<List<Transactions>>

    suspend fun clearAll()
}