package me.sombriks

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class MyLibrary {

    @Value("\${my.config:Hi!}")
    private lateinit var value: String

    fun hello() = value
}
