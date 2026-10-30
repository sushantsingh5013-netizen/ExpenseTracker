package com.example.expensetracker.data.local.converters

import androidx.room.TypeConverter
import com.example.expensetracker.domain.model.BudgetPeriod

class BudgetConverters {

    @TypeConverter
    fun fromBudgetPeriod( period : BudgetPeriod ) : String {
        return period.name
    }

    @TypeConverter
    fun toBudgetPeriod( value : String) : BudgetPeriod{
        return try {
            enumValueOf(value)
        }catch (e : IllegalArgumentException){
            BudgetPeriod.WEEKLY
        }
    }

}