package com.example.dddlibrary.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dddlibrary.domain.model.Book
import com.example.dddlibrary.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books.asStateFlow()

    fun loadBooks() {
        viewModelScope.launch {
            try {
                _books.value = bookRepository.getAllBooks()
            } catch (e: Exception) {
                // Здесь можно обработать ошибку, например, показать сообщение пользователю
            }
        }
    }
}