package com.raywenderlich.android.librarian.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raywenderlich.android.librarian.model.Genre

/**
 * Created By Taufiq on 10/8/2020.
 *
 */
@Dao
interface GenreDao {

    @Query("SELECT * FROM genres")
    fun getGenres(): List<Genre>

    @Query("SELECT * FROM genres WHERE id = :genreId")
    fun getGenreById(genreId: String): Genre

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenres(genres: List<Genre>)
}