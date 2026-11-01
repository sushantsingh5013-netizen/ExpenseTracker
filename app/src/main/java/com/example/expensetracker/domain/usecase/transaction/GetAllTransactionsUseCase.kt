package com.example.expensetracker.domain.usecase.transaction

import com.example.expensetracker.domain.model.Transactions
import com.example.expensetracker.domain.repo.TransactionRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTransactionsUseCase @Inject constructor(
    private val transactionRepo : TransactionRepo
) {
    operator fun invoke() : Flow<List<Transactions>> {
        return transactionRepo.getAllTransactions()
    }

}