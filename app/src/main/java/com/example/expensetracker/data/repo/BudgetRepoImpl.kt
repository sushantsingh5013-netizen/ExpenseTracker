package com.example.expensetracker.data.repo

import com.example.expensetracker.data.local.dao.BudgetDao
import com.example.expensetracker.data.mapper.toDomain
import com.example.expensetracker.data.mapper.toEntity
import com.example.expensetracker.domain.model.Budget
import com.example.expensetracker.domain.repo.BudgetRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BudgetRepoImpl @Inject constructor(
    private val budgetDao : BudgetDao
) : BudgetRepo {
    override suspend fun upsertBudget(budget: Budget) {
        budgetDao.upsertBudget(budget.toEntity())
    }

    override suspend fun deleteBudget(budget: Budget) {
        budgetDao.deleteBudget(budget.toEntity())
    }

    override fun getAllBudgets(): Flow<List<Budget>> {
        return budgetDao.getAllBudgets()
            .map {
                entities ->
                entities.map {
                    it.toDomain()
                }
            }
    }

    override suspend fun getBudgetById(id: String): Budget? {
        return budgetDao.getBudgetById(id)?.toDomain()
    }

    override fun getActiveBudgets(): Flow<List<Budget>> {
        return budgetDao.getActiveBudgets()
            .map {
                entities ->
                entities.map {
                    it.toDomain()
                }
            }
    }

    override fun getBudgetByCategory(categoryId: String): Flow<Budget?> {
        return budgetDao.getBudgetByCategory(categoryId)
            .map {
                entity ->
                entity?.toDomain()
            }
    }
}

