package me.sombriks.controllers

import me.sombriks.MyLibrary
import me.sombriks.models.Todo
import me.sombriks.repositories.TodoRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("todos")
class TodoController(
    private val repository: TodoRepository,
    private val lib: MyLibrary
) {

    @GetMapping("xpto")
    fun sayHi(): String {
        return lib.hello()
    }

    @GetMapping
    fun list() = repository.findAll()

    @GetMapping("{id}")
    fun find(@PathVariable("id") id: Int) = repository.findById(id)

    @PostMapping
    fun create(@RequestBody newTodo: Todo) = repository.save(newTodo)

    @PutMapping("{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody todo: Todo): Todo {
        todo.id = id
        return repository.save(todo)
    }

    @DeleteMapping("{id}")
    fun del(@PathVariable("id") id: Int) = repository.deleteById(id)
}
