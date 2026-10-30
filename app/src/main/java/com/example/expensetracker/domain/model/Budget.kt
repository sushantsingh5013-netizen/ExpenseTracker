package com.example.expensetracker.domain.model

data class Budget(
    val id : String,
    val name : String,
    val amount : Long,
    val categoryId : String?,
    val period : BudgetPeriod,
    val startDate : Long,
    val endDate : Long? = null,
    val createdAt : Long,
    val isActive : Boolean = true
)

enum class BudgetPeriod{
    WEEKLY,
    MONTHLY,
    YEARLY
}
