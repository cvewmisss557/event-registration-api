package kz.iitu.registration.controller;

import kz.iitu.registration.service.EventService;
import kz.iitu.registration.model.EventInfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final EventService eventService;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${app.course}")
    private String course;

    @Value("${app.semester}")
    private String semester;

    public RegistrationController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of(
            "message",
            eventService.getWelcomeMessage()
        );
    }

    // GET: Get all events or search by title
    @GetMapping("/events")
    public ResponseEntity<List<EventInfo>> getEvents(
            @RequestParam(required = false) String title) {

        List<EventInfo> events = eventService.getAllEvents(title);

        return ResponseEntity.ok(events);
    }

    // GET: Get event by ID
    @GetMapping("/events/{id}")
    public ResponseEntity<?> getEventById(@PathVariable int id) {

        Optional<EventInfo> event = eventService.getEventById(id);

        if (event.isPresent()) {
            return ResponseEntity.ok(event.get());
        }

        return ResponseEntity.notFound().build();
    }

    // POST: Add new event
    @PostMapping("/events")
    public ResponseEntity<?> addEvent(@RequestBody EventInfo event) {

        if (event.getTitle() == null || event.getTitle().isBlank()
                || event.getLocation() == null
                || event.getLocation().isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Title and location cannot be empty");
        }

        EventInfo newEvent = eventService.addEvent(
            event.getTitle(),
            event.getLocation()
        );

        return ResponseEntity.status(201).body(newEvent);
    }

    // PUT: Update event
    @PutMapping("/events/{id}")
    public ResponseEntity<?> updateEvent(
            @PathVariable int id,
            @RequestBody EventInfo event) {

        if (event.getTitle() == null || event.getTitle().isBlank()
                || event.getLocation() == null
                || event.getLocation().isBlank()) {

            return ResponseEntity.badRequest()
                    .body("Title and location cannot be empty");
        }

        Optional<EventInfo> updatedEvent = eventService.updateEvent(
            id,
            event.getTitle(),
            event.getLocation()
        );

        if (updatedEvent.isPresent()) {
            return ResponseEntity.ok(updatedEvent.get());
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE: Delete event
    @DeleteMapping("/events/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable int id) {

        boolean deleted = eventService.deleteEvent(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        return Map.of(
            "application", appName,
            "course", course,
            "semester", semester
        );
    }
}