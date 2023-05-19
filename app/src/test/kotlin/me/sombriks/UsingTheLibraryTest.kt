package me.sombriks

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.runner.ApplicationContextRunner


@SpringBootTest
class UsingTheLibraryTest {

    @Autowired
    private lateinit var service: MyLibrary

    @Test
    fun `should get default value since there is no config`(){
        ApplicationContextRunner()
            .withBean(MyLibrary::class.java)
//            .withPropertyValues("my.config=I'm a genius!")
            .run {
                var service = it.getBean(MyLibrary::class.java)
                Assertions.assertEquals("Hi!", service.hello())
            }
    }

    @Test
    fun `should get value from provided config`(){
        ApplicationContextRunner()
            .withBean(MyLibrary::class.java)
            .withPropertyValues("my.config=I am batman!")
            .run {
                var service = it.getBean(MyLibrary::class.java)
                Assertions.assertEquals("I am batman!", service.hello())
            }
    }

    @Test
    fun `should get autoconfigured value`() {
        Assertions.assertEquals("Hello there!", service.hello())
    }
}
