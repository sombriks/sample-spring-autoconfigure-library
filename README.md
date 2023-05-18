# sample-spring-autoconfigure-library

Sampling autoconfigure libraries for spring.

Whenever we want a bean to be properly defined already when adding a
spring-aware library into classpath, a few steps must be taken:

- Create a `@Configuration` for the library
- declare it into `META-INF/spring.factories`

