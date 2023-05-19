# sample-spring-autoconfigure-library

Sampling autoconfigure libraries for spring.

Whenever we want a bean to be properly defined already when adding a
spring-aware library into classpath, a few steps must be taken:

- Create a `@Configuration` for the library
- Declare it into `META-INF/spring.factories`
- Create a specific properties file for reasonable defaults 

See testcases from the library and the consuming application for details
