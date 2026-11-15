Event Registration API

Project Description
This project is a simple backend application developed using Spring Boot.

It provides REST API endpoints for displaying a welcome message, event information, and application details.

Technologies Used
- Java 17
- Spring Boot
- Gradle
- Spring Web

Project Srtucture
- controller – handles HTTP requests.
- service – contains application logic.
- model – stores event information.

API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/hello` | Returns a welcome message |
| GET | `/api/events` | Returns a list of events |
| GET | `/api/info` | Returns application information |

How to run

1. Open the project folder.
2. Open the terminal.
3. Run the following command:

```bash
.\gradlew.bat bootRun
```

4. Open your browser and visit:

- http://localhost:8080/api/hello
- http://localhost:8080/api/events
- http://localhost:8080/api/info

Dependency Injection

The project uses constructor-based dependency injection. The RegistrationController receives EventService through its constructor.

Conclusion

This project helped me understand Spring Boot, REST API endpoints, services, controllers, and dependency injection.