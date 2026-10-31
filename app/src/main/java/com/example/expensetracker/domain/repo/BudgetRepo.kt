package com.example.expensetracker.domain.repo

import com.example.expensetracker.domain.model.Budget
import kotlinx.coroutines.flow.Flow

interface BudgetRepo {
    suspend fun upsertBudget(budget : Budget)

    suspend fun deleteBudget(budget: Budget)

    fun getAllBudgets() : Flow<List<Budget>>

    suspend fun getBudgetById(id : String) : Budget?

    fun getActiveBudgets() : Flow<List<Budget>>

    fun getBudgetByCategory(categoryId : String) : Flow<Budget?>
}