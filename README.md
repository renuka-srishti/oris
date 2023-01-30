# Laureates Count API

The web service returns the number of laureates by country (of birth) and sort them in
descending order. Laureates are fetched from nobel prize [API](https://www.nobelprize.org/about/developer-zone-2/.
). 

The country with the highest number of laureates should appear first in
the list, followed by next highest and so on. If two countries have the same laureate count,
they can appear in any order.

Access the Laureates Count API: https://laureate-count-application.herokuapp.com/laureate-count

## Project Dependencies

Project has below dependencies:
- Java JDK 17
- Maven 3.6.3
- Spring Boot 2.6.2

## Technologies/Libraries Used
All the libraries and dependencies can be found in `pom.xml` file. Below are the major ones:

- Spring Boot
- Lombok
- JUnit 4
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

**Local Endpoint:** [http://127.0.0.1:8080/laureate-count](http://127.0.0.1:8080/laureate-count)

**Response:**
```json
[
    {
        "country": "USA",
        "count": 286
    },
    {
        "country": "United Kingdom",
        "count": 89
    },
    {
        "country": "Germany",
        "count": 80
    },
    {
        "country": "France",
        "count": 56
    },
    {
        "country": "Sweden",
        "count": 30
    },
    {
        "country": "Japan",
        "count": 28
    },
    {
        "country": "Canada",
        "count": 21
    },
    {
        "country": "the Netherlands",
        "count": 19
    },
    {
        "country": "Switzerland",
        "count": 19
    },
    {
        "country": "Italy",
        "count": 18
    },
    {
        "country": "Russia",
        "count": 18
    },
    {
        "country": "Austria",
        "count": 16
    },
    {
        "country": "Russian Empire",
        "count": 16
    },
    {
        "country": "Prussia",
        "count": 13
    },
    {
        "country": "Austria-Hungary",
        "count": 13
    },
    {
        "country": "Norway",
        "count": 12
    },
    {
        "country": "Denmark",
        "count": 12
    },
    {
        "country": "Scotland",
        "count": 11
    },
    {
        "country": "China",
        "count": 11
    },
    {
        "country": "India",
        "count": 10
    },
    {
        "country": "Australia",
        "count": 10
    },
    {
        "country": "Belgium",
        "count": 9
    },
    {
        "country": "South Africa",
        "count": 9
    },
    {
        "country": "Poland",
        "count": 9
    },
    {
        "country": "Spain",
        "count": 7
    },
    {
        "country": "Hungary",
        "count": 7
    },
    {
        "country": "USSR",
        "count": 6
    },
    {
        "country": "Egypt",
        "count": 6
    },
    {
        "country": "Northern Ireland",
        "count": 5
    },
    {
        "country": "West Germany",
        "count": 5
    },
    {
        "country": "British Mandate of Palestine",
        "count": 5
    },
    {
        "country": "Ireland",
        "count": 5
    },
    {
        "country": "Austrian Empire",
        "count": 4
    },
    {
        "country": "Argentina",
        "count": 4
    },
    {
        "country": "Romania",
        "count": 4
    },
    {
        "country": "New Zealand",
        "count": 3
    },
    {
        "country": "Mexico",
        "count": 3
    },
    {
        "country": "East Timor",
        "count": 2
    },
    {
        "country": "Portugal",
        "count": 2
    },
    {
        "country": "Guatemala",
        "count": 2
    },
    {
        "country": "Chile",
        "count": 2
    },
    {
        "country": "British India",
        "count": 2
    },
    {
        "country": "Turkey",
        "count": 2
    },
    {
        "country": "Finland",
        "count": 2
    },
    {
        "country": "Ottoman Empire",
        "count": 2
    },
    {
        "country": "Liberia",
        "count": 2
    },
    {
        "country": "Luxembourg",
        "count": 2
    },
    {
        "country": "Colombia",
        "count": 2
    },
    {
        "country": "Schleswig",
        "count": 2
    },
    {
        "country": "French Algeria",
        "count": 2
    },
    {
        "country": "Korea",
        "count": 2
    },
    {
        "country": "Tibet",
        "count": 1
    },
    {
        "country": "Württemberg",
        "count": 1
    },
    {
        "country": "Bavaria",
        "count": 1
    },
    {
        "country": "Guadeloupe Island",
        "count": 1
    },
    {
        "country": "Morocco",
        "count": 1
    },
    {
        "country": "Iran",
        "count": 1
    },
    {
        "country": "Czechoslovakia",
        "count": 1
    },
    {
        "country": "Iraq",
        "count": 1
    },
    {
        "country": "Faroe Islands (Denmark)",
        "count": 1
    },
    {
        "country": "Ukraine",
        "count": 1
    },
    {
        "country": "Tuscany",
        "count": 1
    },
    {
        "country": "Mecklenburg",
        "count": 1
    },
    {
        "country": "Taiwan",
        "count": 1
    },
    {
        "country": "Trinidad and Tobago",
        "count": 1
    },
    {
        "country": "Peru",
        "count": 1
    },
    {
        "country": "Yemen",
        "count": 1
    },
    {
        "country": "Crete",
        "count": 1
    },
    {
        "country": "Madagascar",
        "count": 1
    },
    {
        "country": "British West Indies",
        "count": 1
    },
    {
        "country": "Costa Rica",
        "count": 1
    },
    {
        "country": "German-occupied Poland",
        "count": 1
    },
    {
        "country": "Bosnia",
        "count": 1
    },
    {
        "country": "Vietnam",
        "count": 1
    },
    {
        "country": "Southern Rhodesia",
        "count": 1
    },
    {
        "country": "Bulgaria",
        "count": 1
    },
    {
        "country": "Nigeria",
        "count": 1
    },
    {
        "country": "Kenya",
        "count": 1
    },
    {
        "country": "Lebanon",
        "count": 1
    },
    {
        "country": "Venezuela",
        "count": 1
    },
    {
        "country": "Saint Lucia",
        "count": 1
    },
    {
        "country": "Cyprus",
        "count": 1
    },
    {
        "country": "Iceland",
        "count": 1
    },
    {
        "country": "Belgian Congo",
        "count": 1
    },
    {
        "country": "Java, Dutch East Indies",
        "count": 1
    },
    {
        "country": "Brazil",
        "count": 1
    },
    {
        "country": "Gold Coast",
        "count": 1
    },
    {
        "country": "British Protectorate of Palestine",
        "count": 1
    },
    {
        "country": "Ethiopia",
        "count": 1
    },
    {
        "country": "East Friesland",
        "count": 1
    },
    {
        "country": "Pakistan",
        "count": 1
    },
    {
        "country": "Lithuania",
        "count": 1
    },
    {
        "country": "Persia",
        "count": 1
    },
    {
        "country": "Hesse-Kassel",
        "count": 1
    },
    {
        "country": "Philippines",
        "count": 1
    },
    {
        "country": "Burma",
        "count": 1
    },
    {
        "country": "Free City of Danzig",
        "count": 1
    }
]
```