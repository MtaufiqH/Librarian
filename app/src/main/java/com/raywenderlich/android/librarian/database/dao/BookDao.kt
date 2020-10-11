package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Book

/**
 * Created By Taufiq on 10/8/2020.
 *
 */
@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getBooks(): List<Book>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addBook(book: Book)

    @Delete
    fun deleteBook(book: Book)

    @Query("SELECT * FROM books WHERE id=:bookId")
    fun getBookById(bookId: String): Book
}