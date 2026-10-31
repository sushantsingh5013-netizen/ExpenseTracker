package com.example.expensetracker.data.repo

import com.example.expensetracker.data.local.dao.TransactionDao
import com.example.expensetracker.data.mapper.toDomain
import com.example.expensetracker.data.mapper.toEntity
import com.example.expensetracker.domain.model.TransactionType
import com.example.expensetracker.domain.model.Transactions
import com.example.expensetracker.domain.repo.TransactionRepo
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TransactionRepoImpl @Inject constructor(
    private val transactionDao : TransactionDao
) : TransactionRepo{
    override suspend fun upsertTransaction(transaction: Transactions) {
        transactionDao.upsertTransaction(transaction.toEntity())
    }

    override suspend fun deleteTransaction(transaction: Transactions) {
        transactionDao.deleteTransaction(transaction.toEntity())
    }

    override suspend fun getTransactionById(id: String): Transactions? {
        return transactionDao.getTransactionById(id)?.toDomain()
    }

    override fun getAllTransactions(): Flow<List<Transactions>> {
        return transactionDao.getAllTransaction()
            .map {
                entities ->
                entities.map{
                    it.toDomain()
                }
            }
    }

    override fun getTransactionByType(type: TransactionType): Flow<List<Transactions>> {
        return transactionDao.getTransactionByType(type)
            .map{
                entities ->
                entities.map{
                    it.toDomain()
                }
            }
    }

    override fun getTotalByType(type: TransactionType): Flow<Long> {
        return transactionDao.getTotalByType(type)
    }

    override fun getTransactionsByCategory(categoryId: String): Flow<List<Transactions>> {
        return transactionDao.getTransactionsByCategory(categoryId)
            .map {
                entities ->
                entities.map {
                    it.toDomain()
                }
            }
    }

    override fun getTransactionsByDateRange(
        startDate: Long,
        endDate: Long
    ): Flow<List<Transactions>> {
        return transactionDao.getTransactionsByDateRange(startDate, endDate)
            .map {
                entities ->
                entities.map {
                    it.toDomain()
                }
            }
    }

    override suspend fun clearAll() {
        transactionDao.clearAll()
    }
}