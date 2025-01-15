package com.example.dddlibrary.data.datasource

import com.example.dddlibrary.domain.model.Book

interface BookDataSource {
    suspend fun getAllBooks(): List<Book>
    suspend fun getBookById(id: String): Book?
    suspend fun addBook(book: Book)
    suspend fun updateBook(book: Book)
}