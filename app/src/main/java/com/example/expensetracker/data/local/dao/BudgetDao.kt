package com.example.expensetracker.data.local.dao

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.expensetracker.data.local.entity.BudgetEntity
import kotlinx.coroutines.flow.Flow

interface BudgetDao {

    @Upsert
    suspend fun upsertBudget(budget : BudgetEntity)

    @Delete
    suspend fun deleteBudget(budget : BudgetEntity)

    @Query("Select * from budget order by createdAt desc")
    fun getAllBudgets() : Flow<List<BudgetEntity>>

    @Query("Select * from budget where id = :id")
    suspend fun getBudgetById(id : String) : BudgetEntity?

    @Query("Select * from budget where isActive = 1")
    fun getActiveBudgets() : Flow<List<BudgetEntity>>

    @Query("Select * from budget where categoryId = :categoryId and isActive = 1")
    fun getBudgetByCategory(categoryId : String) : Flow<BudgetEntity?>
}