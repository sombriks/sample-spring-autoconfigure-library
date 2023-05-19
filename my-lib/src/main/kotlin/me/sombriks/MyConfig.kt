package me.sombriks

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment


@PropertySource("classpath:my-library.properties")
@Configuration
class MyConfig {

    @Bean
    fun myLibrary(env: Environment): MyLibrary {
        return MyLibrary(env.getProperty("my.config", "Hello from config!"))
    }

}
