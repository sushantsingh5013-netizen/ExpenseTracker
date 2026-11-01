package com.example.expensetracker.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.expensetracker.domain.model.TransactionType

@Entity(
    tableName = "transactions",
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("categoryId"),
        Index("date")
    ]
)
data class TransactionEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val amount: Long,
    val type: TransactionType,
    val categoryId: String,
    val note: String?,
    val date: Long,
    val createdAt: Long,
    val updatedAt: Long
)