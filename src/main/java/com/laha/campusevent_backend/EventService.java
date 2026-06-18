package com.laha.campusevent_backend;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event updateEvent(Long id, Event updatedEvent) {

        Event event = eventRepository.findById(id).orElseThrow();

        event.setEvent(updatedEvent.getEvent());
        event.setLocation(updatedEvent.getLocation());
        event.setDate(updatedEvent.getDate());

        return eventRepository.save(event);
    }
    public Event getEventById(Long id) {
    return eventRepository.findById(id).orElseThrow();
}
}