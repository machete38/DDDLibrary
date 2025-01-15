package com.example.dddlibrary.domain.repository

import com.example.dddlibrary.domain.model.Loan

interface LoanRepository {
    suspend fun createLoan(loan: Loan)
    suspend fun returnBook(loan: Loan)
    suspend fun getActiveLoansByUser(userId: String): List<Loan>
}