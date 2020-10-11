package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.relations.BooksByGenre

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

    @Transaction
    @Query("SELECT * FROM genres WHERE id= :genreId")
    fun getBooksByGenre(genreId: String): BooksByGenre

    @Transaction
    @Query("SELECT * FROM genres")
    fun getBooksByGenre(): List<BooksByGenre>
}