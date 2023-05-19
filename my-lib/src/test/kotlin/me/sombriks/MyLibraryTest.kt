package me.sombriks

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.runner.ApplicationContextRunner

@SpringBootTest(classes = [MyLibrary::class])
class MyLibraryTest {

    @Autowired
    private lateinit var service: MyLibrary

    @Test
    fun `should get prop value`() {
        Assertions.assertEquals("Hi from bean!", service.hello())
    }

    @Test
    fun `should get alternative value`() {
        ApplicationContextRunner()
            .withBean(MyLibrary::class.java)
            .withPropertyValues("my.config=I'm a genius!")
            .run {
                var service = it.getBean(MyLibrary::class.java)
                Assertions.assertEquals("I'm a genius!", service.hello())
            }
    }

    @Test
    fun `should get default value`() {
        ApplicationContextRunner()
            .withBean(MyLibrary::class.java)
            .run {
                var service = it.getBean(MyLibrary::class.java)
                Assertions.assertEquals("Hi from bean!", service.hello())
            }
    }

    @Test
    fun `should get value from configuration factory`() {
        ApplicationContextRunner()
            .withUserConfiguration(MyConfig::class.java)
            .run {
                var service = it.getBean(MyLibrary::class.java)
                Assertions.assertEquals("Hello from config!", service.hello())
            }
    }
}
