package com.example.expensetracker.data.mapper

import com.example.expensetracker.data.local.entity.TransactionEntity
import com.example.expensetracker.domain.model.Transactions

fun TransactionEntity.toDomain() : Transactions {
    return Transactions(
        id = id,
        title = title,
        amount = amount,
        type = type,
        categoryId = categoryId,
        note = note,
        date = date,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun Transactions.toEntity() : TransactionEntity{
    return TransactionEntity(
        id = id,
        title = title,
        amount = amount,
        type = type,
        categoryId = categoryId,
        note = note,
        date = date,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}