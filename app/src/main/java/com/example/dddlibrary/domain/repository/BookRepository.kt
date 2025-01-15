package com.example.dddlibrary.domain.repository

import com.example.dddlibrary.domain.model.Book

interface BookRepository {
    suspend fun getAllBooks(): List<Book>
    suspend fun getBookById(id: String): Book?
    suspend fun addBook(book: Book)
    suspend fun updateBook(book: Book)

}