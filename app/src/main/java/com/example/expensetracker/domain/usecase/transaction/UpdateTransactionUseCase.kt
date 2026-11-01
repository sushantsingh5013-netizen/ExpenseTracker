package com.example.expensetracker.domain.usecase.transaction

import com.example.expensetracker.domain.model.Transactions
import com.example.expensetracker.domain.repo.CategoryRepo
import com.example.expensetracker.domain.repo.TransactionRepo
import javax.inject.Inject

class UpdateTransactionUseCase @Inject constructor(
    private val transactionRepo : TransactionRepo,
    private val categoryRepo : CategoryRepo
) {
    suspend operator fun invoke(
        transaction : Transactions
    ) : Result<Unit>{
        return try{
            val existingTransaction = transactionRepo.getTransactionById(transaction.id)
                ?: return Result.failure(
                    IllegalArgumentException("Transaction does not exist")
                )

            if(transaction.title.isBlank()){
                return Result.failure(
                    IllegalArgumentException("Title cannot be empty")
                )
            }

            if(transaction.amount <= 0L){
                return Result.failure(
                    IllegalArgumentException("Amount must be greater than zero")
                )
            }

            val category = categoryRepo.getCategoryById(
                transaction.categoryId
            ) ?: return Result.failure(
                IllegalArgumentException("Category does not exists")
            )

            if(!category.isActive){
                return Result.failure(
                    IllegalArgumentException("Selected category is inactive")
                )
            }

            if(category.type != transaction.type){
                return Result.failure(
                    IllegalArgumentException("Category type does not match transaction type")
                )
            }

            val updatedTransaction = transaction.copy(
                createdAt = existingTransaction.createdAt,
                updatedAt = System.currentTimeMillis()
            )

            transactionRepo.upsertTransaction(updatedTransaction)

            Result.success(Unit)
        }catch (e : Exception){
            Result.failure(e)
        }
    }
}