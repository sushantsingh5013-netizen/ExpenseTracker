package com.example.expensetracker.data.local.converters

import androidx.room.TypeConverter
import com.example.expensetracker.domain.model.TransactionType

class TransactionConverters {

    @TypeConverter
    fun fromTransactionType(type : TransactionType) : String {
        return type.name
    }

    @TypeConverter
    fun toTransactionType(value : String) : TransactionType {
        return try{
            enumValueOf<TransactionType>(value)
        }catch (e : IllegalArgumentException){
            TransactionType.EXPENSE
        }
    }
}