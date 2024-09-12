package com.todoapp.ci

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import composables.Todo
import composables.TodoCard
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        val (content, setContent) = remember { mutableStateOf("") }
        val (todos, setTodos) = remember { mutableStateOf(mutableListOf<Todo>()) }

        fun addTodo() {
            val newTodos = todos.toMutableList()
            newTodos.add(Todo(content = content, checked = false))
            println("new Todos: $newTodos")
            setTodos(newTodos)
            setContent("")
        }

        fun removeTodo(index: Int) {
            val newTodos = todos.toMutableList()
            newTodos.removeAt(index = index)
            setTodos(newTodos)
        }

        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            content = { _ ->
                Column {
                    TextField(
                        value = content,
                        onValueChange = setContent,
                        placeholder = { Text("Veuillez entrer une tâche") },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(fontSize = 20.sp)
                    )

                    Button(content = { Text("Ajouter") }, onClick = { addTodo() })

                    Column {
                        todos.forEachIndexed { index, todo ->
                            TodoCard(todo, onDelete = { removeTodo(index) })
                        }
                    }


                }
            }
        )
    }
}