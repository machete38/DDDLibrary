package com.example.dddlibrary.domain.usecase

import com.example.dddlibrary.domain.model.BookStatus
import com.example.dddlibrary.domain.model.Loan
import com.example.dddlibrary.domain.model.User
import com.example.dddlibrary.domain.repository.BookRepository
import com.example.dddlibrary.domain.repository.LoanRepository
import java.util.Date
import java.util.UUID

class BorrowBookUseCase(
    private val bookReposibory: BookRepository,
    private val loanRepository: LoanRepository
) {
    suspend fun invoke(bookId: String, userId: String): Result<Loan> {
        val book = bookReposibory.getBookById(bookId)
            ?: return Result.failure(Exception("Книга не найдена"))
        if (book.status == BookStatus.BORROWED) return Result.failure(Exception("Книга уже занята"))

        book.status = BookStatus.BORROWED
        bookReposibory.updateBook(book)

        val loan = Loan(
            id = UUID.randomUUID().toString(),
            book = book,
            user = User(id = userId, name = "user1"),
            loanDate = Date(),
            returnDate = null
        )
        loanRepository.createLoan(loan)

        return Result.success(loan)
    }
}