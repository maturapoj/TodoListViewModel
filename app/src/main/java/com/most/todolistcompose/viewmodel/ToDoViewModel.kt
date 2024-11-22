package com.most.todolistcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.most.todolistcompose.model.ToDoItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ToDoViewModel : ViewModel() {

    private val _toDoList = MutableStateFlow<List<ToDoItem>>(emptyList())
    val toDoList: StateFlow<List<ToDoItem>> = _toDoList.asStateFlow()

    private var nextId = 1

    fun addTask(task: String) {
        if (task.isNotBlank()) {
            _toDoList.value += ToDoItem(nextId++, task)
        }
    }

    fun removeTask(itemId: Int) {
        _toDoList.value = _toDoList.value.filter { it.id != itemId }
    }
}