package me.sombriks

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [MyLibrary::class])
class MyLibraryTest {

    @Test
    fun contextLoads(){}
}
