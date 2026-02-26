package monportfolio.portfoliobackend.controller;

import monportfolio.portfoliobackend.service.GoogleCalendarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class GoogleCalendarController {

    private final GoogleCalendarService calendarService;

    public GoogleCalendarController(GoogleCalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/api/google/calendar/events")
    public String fetchEvents() {
        try {
            calendarService.printUpcomingEvents();
            return "Événements affichés dans la console.";
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
            return "Erreur lors de l'accès au calendrier Google : " + e.getMessage();
        }
    }
}
