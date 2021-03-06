package com.raywenderlich.android.librarian.repository

import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.BooksByGenre
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks
import kotlinx.coroutines.flow.Flow

/**
 * Created By Taufiq on 10/8/2020.
 *
 */

interface LibrarianRepository {

    suspend fun addBook(book: Book)

    suspend fun getBooks(): List<BookAndGenre>

    fun getBookById(bookId: String): Book

    suspend fun deleteBooks(book: Book)

    fun getGenres(): List<Genre>

    fun getGenreById(genreId: String): Genre

    fun addGenres(genres: List<Genre>)

    fun addreview(review: Review)

    fun getReviews(): List<BookReview>

    fun getReviewsFlow(): Flow<List<BookReview>>

    fun getReviewById(reviewId: String): BookReview

    fun deleteReview(review: Review)

    fun updateReview(review: Review)

    suspend fun addReadingList(readingList: ReadingList)

    suspend fun getReadingList(): List<ReadingListsWithBooks>

    fun getReadingListFlow(): Flow<List<ReadingListsWithBooks>>

    suspend fun removeReadingList(readingList: ReadingList)

    fun getBooksByGenre(genreId: String): List<BookAndGenre>

    fun getBooksByRating(rating: Int): List<BookAndGenre>
}