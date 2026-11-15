package kz.iitu.registration.service;

import kz.iitu.registration.model.EventInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    public String getWelcomeMessage() {
        return "Welcome to the Event Registration API";
    }

    private final List<EventInfo> events = List.of(
        new EventInfo(1, "Web Design Workshop", "Almaty"),
        new EventInfo(2, "JavaScript Quiz", "Astana"),
        new EventInfo(3, "IT Career Talk", "Shymkent")
    );

    public List<EventInfo> getAllEvents() {
        return events;
    }
}