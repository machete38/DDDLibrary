package com.example.dddlibrary.domain.model

data class Book (
    val id: String,
    val title: String,
    val author: String,
    val isbn: ISBN,
    var status: BookStatus
)

data class ISBN(val value: String)

enum class BookStatus{
    AVAILABLE, BORROWED
}