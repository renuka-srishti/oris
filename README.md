# Laureates Count API

## Project Dependencies

Project has below dependencies:
- Java JDK 11
- Maven 3.6.3
- Spring Boot 2.6.2

## Technologies/Libraries Used
All the libraries and dependencies can be found in `pom.xml` file. Below are the major ones:

- Spring Boot
- Lombok
- JUnit 5
- Mockito

## Running the application locally
- Install Java 17 or openjdk-17.
- Install [maven](https://maven.apache.org/install.html).
- Clone this repository.
- `cd uw`.
- run `./mvnw spring-boot:run`
- Wait for below log messages
```
2023-01-29T19:22:26.483-08:00  INFO 2061 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-01-29T19:22:26.493-08:00  INFO 2061 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2357 ms
2023-01-29T19:22:28.061-08:00  INFO 2061 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-01-29T19:22:28.073-08:00  INFO 2061 --- [           main] com.uw.oris.LaureateCountApplication     : Started LaureateCountApplication in 5.139 seconds (process running for 5.877)
2023-01-29T19:22:35.601-08:00  INFO 2061 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-01-29T19:22:35.601-08:00  INFO 2061 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-01-29T19:22:35.602-08:00  INFO 2061 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms

```

**API:** [http://127.0.0.1:8080/laureate-count](http://127.0.0.1:8080/laureate-count)