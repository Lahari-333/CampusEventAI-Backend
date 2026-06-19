package com.laha.campusevent_backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class HomeController {

    private final EventService eventService;
    private final RegistrationService registrationService;
    private final UserService userService;

    public HomeController(
            EventService eventService,
            RegistrationService registrationService,
            UserService userService) {

        this.eventService = eventService;
        this.registrationService = registrationService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "Campus Event AI Backend Running!";
    }

    // EVENTS

    @GetMapping("/events")
    public List<Event> events() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/events/add")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/events/{id}")
    public Event updateEvent(
            @PathVariable Long id,
            @RequestBody Event event) {

        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("/events/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event Deleted Successfully";
    }

    // REGISTRATIONS

    @PostMapping("/register")
    public Registration register(
            @RequestBody Registration registration) {

        return registrationService.register(registration);
    }

    @GetMapping("/registrations")
    public List<Registration> registrations() {

        return registrationService.getAllRegistrations();
    }

    // USERS

    @PostMapping("/signup")
    public User signup(
            @RequestBody User user) {

        return userService.signup(user);
    }

    @PostMapping("/login")
public User login(
        @RequestBody User user) {

    return userService.login(
            user.getUsername(),
            user.getPassword()
    );
}
}