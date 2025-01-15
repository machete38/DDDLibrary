package com.example.dddlibrary.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.dddlibrary.domain.model.Book
import com.example.dddlibrary.domain.repository.BookRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(private val bookRepository: BookRepository) : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun loadBooks() {
        viewModelScope.launch {
            _books.value = bookRepository.getAllBooks()
        }
    }
}