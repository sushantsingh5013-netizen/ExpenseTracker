package com.example.expensetracker.domain.model

data class Transactions(
    val id : String,
    val title : String,
    val amount : Long,
    val type : TransactionType,
    val categoryId : String?,
    val note : String? = null,
    val date : Long,
    val createdAt : Long,
    val updatedAt : Long
)

enum class TransactionType{
    INCOME,
    EXPENSE
}
