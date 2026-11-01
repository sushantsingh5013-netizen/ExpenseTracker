package com.example.expensetracker.data.repo

import com.example.expensetracker.data.local.dao.CategoryDao
import com.example.expensetracker.data.mapper.toDomain
import com.example.expensetracker.data.mapper.toEntity
import com.example.expensetracker.domain.model.Category
import com.example.expensetracker.domain.model.TransactionType
import com.example.expensetracker.domain.repo.CategoryRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CategoryRepoImpl @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryRepo {
    override suspend fun upsertCategory(category: Category) {
        categoryDao.upsertCategory(category.toEntity())
    }

    override suspend fun deactivateCategory(categoryId: String) {
        categoryDao.deactivateCategory(categoryId)
    }

    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories()
            .map {
                entities ->
                entities.map {
                    it.toDomain()
                }
            }
    }

    override suspend fun getCategoryById(id: String): Category? {
        return categoryDao.getCategoryById(id)?.toDomain()
    }

    override fun getCategoriesByType(type: TransactionType): Flow<List<Category>> {
        return categoryDao.getCategoriesByType(type)
            .map {
                entities ->
                entities.map {
                    it.toDomain()
                }
            }
    }

    override fun getAllActiveCategories(): Flow<List<Category>> {
        return categoryDao.getAllActiveCategories()
            .map {
                entities ->
                entities.map {
                    it.toDomain()
                }
            }
    }
}