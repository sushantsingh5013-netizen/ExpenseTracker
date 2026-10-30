package com.example.expensetracker.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import com.example.expensetracker.domain.model.BudgetPeriod

@Entity(
    tableName = "budget",
    indices = [
        Index("categoryId", "isActive")
    ]
)
data class BudgetEntity(
    val id : String,
    val name : String,
    val amount : Long,
    val categoryId : String?,
    val period : BudgetPeriod,
    val startDate : Long? = null,
    val createdAt : Long,
    val isActive : Boolean = true
)
