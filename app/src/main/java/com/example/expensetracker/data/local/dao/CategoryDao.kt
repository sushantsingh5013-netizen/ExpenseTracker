package com.example.expensetracker.data.local.dao

import androidx.room.Query
import androidx.room.Upsert
import com.example.expensetracker.data.local.entity.CategoryEntity
import com.example.expensetracker.domain.model.TransactionType
import kotlinx.coroutines.flow.Flow

interface CategoryDao {

    @Upsert
    suspend fun upsertCategory(category : CategoryEntity)

    @Query("Update category set isActive = 0 where id = :categoryId")
    suspend fun deactivateCategory(categoryId : String)

    @Query("Select * from category")
    fun getAllCategories() : Flow<List<CategoryEntity>>

    @Query("Select * from category where id = :id")
    suspend fun getCategoryById(id : String) : CategoryEntity?

    @Query("Select * from category where type = :type and isActive = 1 order by name asc")
    fun getCategoriesByType(type : TransactionType) : Flow<List<CategoryEntity>>

    @Query("Select * from category where isActive = 1 order by name asc")
    fun getAllActiveCategories() : Flow<List<CategoryEntity>>

}