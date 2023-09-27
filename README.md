# statnett-backend
A Ktor web-server written in Kotlin providing an API-proxy to weather and earthquake data
from the following endpoints:
    - `http:localhost:8080/api/met`
    - `http:localhost:8080/api/earthquake`

### Building and running the application
  - Run `./gradlew task shadowJar` in project root
  - Run `java -jar build/libs/statnett-backend-1.0-all.jar` from project root.

Alternatively the jar file can be started in a Docker-container:
  - Run `./gradlew task shadowJar` in project root
  - Run `docker build -t statnett-backend .` in project root.
  - Run `docker run -it -p 8080:8080 --rm statnett-backend`
