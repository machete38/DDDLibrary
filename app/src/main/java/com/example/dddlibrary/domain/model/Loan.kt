package com.example.dddlibrary.domain.model

import java.util.Date

data class Loan(
    val id: String,
    val book: Book,
    val user: User,
    val loanDate: Date,
    var returnDate: Date?
    )