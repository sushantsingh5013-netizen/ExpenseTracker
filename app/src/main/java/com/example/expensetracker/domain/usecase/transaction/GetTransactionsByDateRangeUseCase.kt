package com.example.expensetracker.domain.usecase.transaction

import com.example.expensetracker.domain.model.Transactions
import com.example.expensetracker.domain.repo.TransactionRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionsByDateRangeUseCase @Inject constructor(
    private val transactionRepo : TransactionRepo
) {
    operator fun invoke(startDate : Long, endDate : Long) : Flow<List<Transactions>> {
        require(startDate <= endDate){
            "Start date cannot be after end date"
        }
        return transactionRepo.getTransactionsByDateRange(startDate, endDate)
    }
}