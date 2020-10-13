package com.raywenderlich.android.librarian.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * Created By Taufiq on 10/13/2020.
 *
 */

val migration_1_2  = object : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Review ADD COLUMN lastUpdateDate INTEGER NOT NULL DEFAULT 0")
    }

}