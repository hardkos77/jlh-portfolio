package monportfolio.portfoliobackend.model;

import java.time.LocalDateTime;

public record CalendarSlot(LocalDateTime datetime, boolean available) {}
