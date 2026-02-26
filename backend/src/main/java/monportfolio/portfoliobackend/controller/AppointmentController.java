package monportfolio.portfoliobackend.controller;

import monportfolio.portfoliobackend.dto.AppointmentDTO;
import monportfolio.portfoliobackend.entity.Appointment;
import monportfolio.portfoliobackend.model.CalendarSlot;
import monportfolio.portfoliobackend.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return service.create(appointment);
    }

    @GetMapping
    public List<AppointmentDTO> getAll() {
        return service.getAll().stream()
                .map(appt -> new AppointmentDTO(
                        appt.getFullName(),
                        appt.getEmail(),
                        appt.getReason(),
                        appt.getScheduledAt(),
                        appt.getStatus().name()
                ))
                .toList();
    }

    @PutMapping("/{id}/status")
    public Appointment updateStatus(@PathVariable Long id, @RequestParam Appointment.Status status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/slots")
    public List<CalendarSlot> getSlots() {
        // Ex : liste de 10 créneaux à partir de maintenant
        LocalDateTime now = LocalDateTime.now().withMinute(0).withSecond(0).withNano(0);
        List<Appointment> taken = service.getAll();

        return IntStream.range(1, 11)
                .mapToObj(i -> now.plusHours(i))
                .map(date -> new CalendarSlot(
                        date,
                        taken.stream().noneMatch(a -> a.getScheduledAt().equals(date))
                ))
                .toList();
    }
}
