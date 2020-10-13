package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookReview

/**
 * Created By Taufiq on 10/8/2020.
 *
 */

@Dao
interface ReviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReview(review: Review)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateReview(review: Review)

    @Query("SELECT * FROM review")
    fun getReview(): List<BookReview>

    @Query("SELECT * FROM review WHERE id = :reviewId")
    fun getReviewById(reviewId: String): BookReview

    @Delete
    fun deleteReview(review: Review)

    @Query("SELECT * FROM review where rating = :rating")
    fun getReviewByRating(rating: Int): List<BookReview>

}