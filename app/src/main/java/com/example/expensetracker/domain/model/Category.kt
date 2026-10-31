package com.example.expensetracker.domain.model

data class Category(
    val id : String,
    val name : String,
    val type : TransactionType,
    val icon : String,
    val color : String,
    val isDefault : Boolean = false,
    val createdAt : Long,
    val isActive : Boolean = true
)
