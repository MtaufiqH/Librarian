package com.raywenderlich.android.librarian.repository

import com.raywenderlich.android.librarian.database.dao.BookDao
import com.raywenderlich.android.librarian.database.dao.GenreDao
import com.raywenderlich.android.librarian.database.dao.ReadingListDao
import com.raywenderlich.android.librarian.database.dao.ReviewDao
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks

/**
 * Created By Taufiq on 10/8/2020.
 *
 */
class LibrarianRepositoryImpl(
        private val bookDao: BookDao,
        private val genreDao: GenreDao,
        private val readingListDao: ReadingListDao,
        private val reviewDao: ReviewDao
) : LibrarianRepository {

    override fun addBook(book: Book) {
        bookDao.addBook(book)
    }

    override fun getBooks(): List<BookAndGenre> {
        return bookDao.getBooks()
    }

    override fun getBookById(bookId: String): Book {
        return bookDao.getBookById(bookId)
    }

    override fun deleteBooks(book: Book) = bookDao.deleteBook(book)

    override fun getGenres(): List<Genre> {
        return genreDao.getGenres()
    }

    override fun getGenreById(genreId: String): Genre {
        return genreDao.getGenreById(genreId)
    }

    override fun addGenres(genres: List<Genre>) {
        genreDao.addGenres(genres)
    }

    override fun addreview(review: Review) = reviewDao.addReview(review)

    override fun updateReview(review: Review) = reviewDao.updateReview(review)

    override fun getReviewById(reviewId: String): BookReview {
        val review = reviewDao.getReviewById(reviewId)
        return BookReview(review, bookDao.getBookById(review.bookId))

    }

    override fun deleteReview(review: Review) {
        TODO("Not yet implemented")
    }

    override fun getReviews(): List<BookReview> {
        return reviewDao.getReview().map {
            BookReview(it, bookDao.getBookById(it.bookId))
        }
    }

//    override fun deleteReview(review: BookReview) {
//
//    }

    override fun addReadingList(readingList: ReadingList) = readingListDao.addReadingList(readingList)

    override fun getReadingList(): List<ReadingListsWithBooks> =
        readingListDao.getReadingList().map {
            ReadingListsWithBooks(it.id, it.name, emptyList())
    }

    override fun removeReadingList(readingList: ReadingList) {
        readingListDao.deleteReadingList(readingList)
    }

}