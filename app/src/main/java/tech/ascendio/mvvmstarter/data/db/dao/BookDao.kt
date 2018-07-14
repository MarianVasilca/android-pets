package tech.ascendio.mvvmstarter.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import tech.ascendio.mvvmstarter.data.vo.Book

/*
 * Copyright (C) 2018 Marian Vasilca@Ascendio TechVision
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Interface for database access for [Book] related operations.
 */
@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(books: Array<Book>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(books: List<Book>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: Book)

    @Query("SELECT * FROM books")
    fun listenForBooks(): Flowable<List<Book>>

    @Query("SELECT * FROM books WHERE isbn = :isbn")
    fun findByISBN(isbn: String): Flowable<Book>

    @Query("DELETE FROM books")
    fun deleteBooks()
}