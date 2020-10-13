package com.raywenderlich.android.librarian.database.converters

import androidx.room.TypeConverter
import java.util.*

/**
 * Created By Taufiq on 10/13/2020.
 *
 */
class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date?{
        return Date(value ?: 0)
    }


    @TypeConverter
    fun dateToTimeStamp(date: Date?): Long = date?.time ?: 0
}