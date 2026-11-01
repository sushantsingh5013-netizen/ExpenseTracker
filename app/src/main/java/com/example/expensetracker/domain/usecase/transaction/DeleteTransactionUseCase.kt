package com.example.expensetracker.domain.usecase.transaction

import com.example.expensetracker.domain.model.Transactions
import com.example.expensetracker.domain.repo.TransactionRepo
import javax.inject.Inject

class DeleteTransactionUseCase @Inject constructor(
    private val transactionRepo : TransactionRepo
) {
    suspend operator fun invoke(
        transactionId : String
    ) : Result<Unit> {
        return try {
            val transaction = transactionRepo.getTransactionById(transactionId)
                ?: return Result.failure(
                    IllegalArgumentException("Transaction does not exist")
                )

            transactionRepo.deleteTransaction(transaction)

            Result.success(Unit)

        }catch (e : Exception){
            Result.failure(e)
        }
    }
}