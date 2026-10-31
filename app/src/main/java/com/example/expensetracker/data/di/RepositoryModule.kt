package com.example.expensetracker.data.di

import com.example.expensetracker.data.repo.BudgetRepoImpl
import com.example.expensetracker.data.repo.CategoryRepoImpl
import com.example.expensetracker.data.repo.TransactionRepoImpl
import com.example.expensetracker.domain.repo.BudgetRepo
import com.example.expensetracker.domain.repo.CategoryRepo
import com.example.expensetracker.domain.repo.TransactionRepo
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindTransactionRepo(
        implementation : TransactionRepoImpl
    ) : TransactionRepo

    @Binds
    abstract fun bindCategoryRepo(
        implementation: CategoryRepoImpl
    ) : CategoryRepo

    @Binds
    abstract fun bindBudgetRepo(
        implementation : BudgetRepoImpl
    ) : BudgetRepo
}