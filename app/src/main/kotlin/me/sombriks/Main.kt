package me.sombriks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication as runApp

@SpringBootApplication
class Main

fun main(args: Array<String>) {
    runApp<Main>(*args)
}
