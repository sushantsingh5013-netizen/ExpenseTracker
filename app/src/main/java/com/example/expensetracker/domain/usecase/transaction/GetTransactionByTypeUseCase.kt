package com.example.expensetracker.domain.usecase.transaction

import com.example.expensetracker.domain.model.TransactionType
import com.example.expensetracker.domain.model.Transactions
import com.example.expensetracker.domain.repo.TransactionRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionByTypeUseCase @Inject constructor(
    private val transactionRepo : TransactionRepo
) {
    operator fun invoke(
        type : TransactionType
    ) : Flow<List<Transactions>> {
        return transactionRepo.getTransactionByType(type)
    }
}