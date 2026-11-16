Lab 7 -Event Registration API

Project Description

This project is a Spring Boot REST API for managing events. It allows users to create, view, update, search, and delete events.

The project uses an in-memory ArrayList to store event information. No database is required.

Technologies Used

- Java 17
- Spring Boot
- Gradle
- REST API
- Postman
- Git and GitHub

Project Structure

- `EventRegistrationApplication.java` – main application class.
- `EventInfo.java` – model class that stores event information.
- `EventService.java` – contains the business logic and manages events.
- `RegistrationController.java` – handles HTTP requests.

How to Run the Project

1. Open the project folder in Visual Studio Code.
2. Open the terminal in the project directory.
3. Run the following command:

```bash
.\gradlew.bat bootRun
```

4. Wait until the Spring Boot application starts.
5. The API will be available at:

`http://localhost:8080`

API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/events` | Get all events |
| GET | `/api/events/{id}` | Get event by ID |
| GET | `/api/events?title=quiz` | Search events by title |
| POST | `/api/events` | Add a new event |
| PUT | `/api/events/{id}` | Update an event |
| DELETE | `/api/events/{id}` | Delete an event |

Validation

The application checks that the event title and location are not empty. If either field is missing or blank, the API returns `400 Bad Request`.

If an event with the specified ID does not exist, the API returns `404 Not Found`.

Conclusion

In this laboratory work, I learned how to create REST API endpoints using Spring Boot. I practiced GET, POST, PUT, and DELETE requests, used PathVariable, RequestParam, and RequestBody annotations, and tested the API using Postman.