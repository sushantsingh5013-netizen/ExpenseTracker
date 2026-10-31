package com.example.expensetracker.domain.repo

import com.example.expensetracker.domain.model.Category
import com.example.expensetracker.domain.model.TransactionType
import kotlinx.coroutines.flow.Flow

interface CategoryRepo {

    suspend fun upsertCategory(category : Category)

    suspend fun deactivateCategory(categoryId : String)

    fun getAllCategories() : Flow<List<Category>>

    suspend fun getCategoryById(id : String) : Category?

    fun getCategoriesByType(type : TransactionType) : Flow<List<Category>>

    fun getAllActiveCategories() : Flow<List<Category>>


}