package com.example.expensetracker.data.mapper

import com.example.expensetracker.data.local.entity.BudgetEntity
import com.example.expensetracker.domain.model.Budget

fun Budget.toEntity() : BudgetEntity{
    return BudgetEntity(
        id = id,
        name = name,
        amount = amount,
        categoryId = categoryId,
        period = period,
        startDate = startDate,
        endDate = endDate,
        createdAt = createdAt,
        isActive = isActive
    )
}

fun BudgetEntity.toDomain() : Budget{
    return Budget(
        id = id,
        name = name,
        amount = amount,
        categoryId = categoryId,
        period = period,
        startDate = startDate,
        endDate = endDate,
        createdAt = createdAt,
        isActive = isActive
    )
}