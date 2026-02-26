package monportfolio.portfoliobackend.dto;

import java.time.LocalDateTime;

public record AppointmentDTO(
        String fullName,
        String email,
        String reason,
        LocalDateTime scheduledAt,
        String status
) {}
