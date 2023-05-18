package me.sombriks.controllers

import me.sombriks.repositories.TodoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("todos")
class TodoController(private val repository: TodoRepository) {

    @GetMapping("xpto")
    fun sayHi(): String {
        return "hi!"
    }

    @GetMapping
    fun list() = repository.findAll()
}
