package monportfolio.portfoliobackend.model;

import java.time.LocalDateTime;

public record UnavailableSlot(LocalDateTime start, LocalDateTime end) {}
