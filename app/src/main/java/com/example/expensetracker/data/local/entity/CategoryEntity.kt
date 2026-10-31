package com.example.expensetracker.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.expensetracker.domain.model.TransactionType

@Entity(
    tableName = "category",
    indices = [
        Index("name")
    ]
)
data class CategoryEntity(
    @PrimaryKey
    val id : String,
    val name : String,
    val type : TransactionType,
    val icon : String,
    val color : String,
    val isDefault : Boolean = false,
    val createdAt : Long,
    val isActive : Boolean = true
)