package com.example.expensetracker.domain.usecase.transaction

import com.example.expensetracker.domain.model.Transactions
import com.example.expensetracker.domain.repo.TransactionRepo
import javax.inject.Inject

class GetTransactionByIdUseCase @Inject constructor(
    private val transactionRepo : TransactionRepo
) {
    suspend operator fun invoke(id : String) : Transactions?{
        return transactionRepo.getTransactionById(id)
    }
}