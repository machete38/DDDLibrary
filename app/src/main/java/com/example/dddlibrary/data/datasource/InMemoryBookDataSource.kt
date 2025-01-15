package com.example.dddlibrary.data.datasource

import com.example.dddlibrary.domain.model.Book

class InMemoryBookDataSource : BookDataSource {

    private val books = mutableListOf<Book>()

    override suspend fun getAllBooks(): List<Book> = books

    override suspend fun getBookById(id: String): Book? = books.find { it.id == id }

    override suspend fun addBook(book: Book) {
        books.add(book)
    }

    override suspend fun updateBook(book: Book) {
        val index = books.indexOfFirst { it.id == book.id }
        if (index != -1) books[index] = book
    }
}