package com.example.expensetracker.data.mapper

import com.example.expensetracker.data.local.entity.CategoryEntity
import com.example.expensetracker.domain.model.Category

fun CategoryEntity.toDomain() : Category{
    return Category(
        id = id,
        name = name,
        type = type,
        icon = icon,
        color = color,
        isDefault = isDefault,
        createdAt = createdAt,
        isActive = isActive
    )
}

fun Category.toEntity() : CategoryEntity{
    return CategoryEntity(
        id = id,
        name = name,
        type = type,
        icon = icon,
        color = color,
        isDefault = isDefault,
        createdAt = createdAt,
        isActive = isActive
    )
}