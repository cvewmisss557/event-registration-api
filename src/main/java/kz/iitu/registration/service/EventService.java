package kz.iitu.registration.service;

import kz.iitu.registration.model.EventInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    public String getWelcomeMessage() {
        return "Welcome to the Event Registration API";
    }

    private final List<EventInfo> events = new ArrayList<>();

    private int nextId = 4;

    public EventService() {

        events.add(new EventInfo(1, "Web Design Workshop", "Almaty"));
        events.add(new EventInfo(2, "JavaScript Quiz", "Astana"));
        events.add(new EventInfo(3, "IT Career Talk", "Shymkent"));

    }

    public List<EventInfo> getAllEvents(String title) {

        if (title == null || title.isBlank()) {
            return events;
        }

        List<EventInfo> result = new ArrayList<>();

        for (EventInfo event : events) {

            if (event.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {

                result.add(event);
            }
        }

        return result;
    }

    public Optional<EventInfo> getEventById(int id) {

        for (EventInfo event : events) {

            if (event.getId() == id) {
                return Optional.of(event);
            }
        }

        return Optional.empty();
    }

    public EventInfo addEvent(String title, String location) {

        EventInfo event = new EventInfo(nextId, title, location);

        events.add(event);

        nextId++;

        return event;
    }

    public Optional<EventInfo> updateEvent(
            int id, String title, String location) {

        Optional<EventInfo> optionalEvent = getEventById(id);

        if (optionalEvent.isPresent()) {

            EventInfo event = optionalEvent.get();

            event.setTitle(title);
            event.setLocation(location);

            return Optional.of(event);
        }

        return Optional.empty();
    }

    public boolean deleteEvent(int id) {

        Optional<EventInfo> optionalEvent = getEventById(id);

        if (optionalEvent.isPresent()) {

            events.remove(optionalEvent.get());

            return true;
        }

        return false;
    }
}