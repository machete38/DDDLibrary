package com.example.dddlibrary.data.repository

import com.example.dddlibrary.data.datasource.BookDataSource
import com.example.dddlibrary.domain.model.Book
import com.example.dddlibrary.domain.repository.BookRepository

class BookRepositoryImpl(private val bookDataSource: BookDataSource): BookRepository {

    override suspend fun getAllBooks(): List<Book> = bookDataSource.getAllBooks()
    override suspend fun getBookById(id: String) = bookDataSource.getBookById(id)
    override suspend fun addBook(book: Book) = bookDataSource.addBook(book)
    override suspend fun updateBook(book: Book) = bookDataSource.updateBook(book)

}