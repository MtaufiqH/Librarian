package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.ReadingList

/**
 * Created By Taufiq on 10/8/2020.
 *
 */
@Dao
interface ReadingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReadingList(readingList: ReadingList)
    
    
    @Query("SELECT * FROM readinglist")
    fun getReadingList(): List<ReadingList>

    @Delete
    fun deleteReadingList(readingList: ReadingList)
}