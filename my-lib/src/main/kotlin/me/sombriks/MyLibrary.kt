package me.sombriks

import org.springframework.beans.factory.annotation.Value

class MyLibrary(
    @Value("\${my.config:Hi from bean!}")
    private var value: String
) {

    fun hello() = value
}
