package com.example.expensetracker.domain.usecase.transaction

import com.example.expensetracker.domain.model.TransactionType
import com.example.expensetracker.domain.repo.TransactionRepo
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetTotalByTypeUseCase @Inject constructor(
    private val transactionRepo : TransactionRepo
) {
    operator fun invoke(
        type : TransactionType
    ) : Flow<Long> {
        return transactionRepo.getTotalByType(
            type
        )
    }
}