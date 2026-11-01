package com.example.expensetracker.domain.usecase.transaction

import com.example.expensetracker.domain.model.Transactions
import com.example.expensetracker.domain.repo.CategoryRepo
import com.example.expensetracker.domain.repo.TransactionRepo
import javax.inject.Inject

class AddTransactionUseCase @Inject constructor(
    private val transactionRepo : TransactionRepo,
    private val categoryRepo : CategoryRepo
){
    suspend operator fun invoke(
        transaction : Transactions
    ) : Result<Unit>{
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
        )?: return Result.failure(
            IllegalArgumentException("Category does not exist")
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

        return try{
            transactionRepo.upsertTransaction(transaction)
            Result.success(Unit)
        }catch (e : Exception){
            Result.failure(e)
        }

    }


}