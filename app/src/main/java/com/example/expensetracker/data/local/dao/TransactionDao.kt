package com.example.expensetracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.expensetracker.data.local.entity.TransactionEntity
import com.example.expensetracker.domain.model.TransactionType
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao{
    @Upsert
    suspend fun upsertTransaction(transaction : TransactionEntity)

    @Delete
    suspend fun deleteTransaction(transaction: TransactionEntity)

    @Query("Select * From transactions Where id = :id")
    suspend fun getTransactionById(id : String) : TransactionEntity?

    @Query("Select * From transactions order by date desc")
    fun getAllTransaction() : Flow<List<TransactionEntity>>

    @Query("Select * from transactions where categoryId = :categoryId order by date Desc")
    fun getTransactionsByCategory(categoryId : String) : Flow<List<TransactionEntity>>

    @Query("Select * from transactions where date between :startDate and :endDate order by date desc")
    fun getTransactionsByDateRange(startDate : Long, endDate : Long) : Flow<List<TransactionEntity>>

    @Query("Select * from transactions where type = :type Order by date desc")
    fun getTransactionByType(type : TransactionType) : Flow<List<TransactionEntity>>

    @Query("Delete from transactions")
    suspend fun clearAll()

    @Query("Select coalesce(sum(amount), 0) from transactions where type = :type")
    fun getTotalByType(type : TransactionType) : Flow<Long>
}