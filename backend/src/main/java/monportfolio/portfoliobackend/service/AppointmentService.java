package monportfolio.portfoliobackend.service;

import monportfolio.portfoliobackend.entity.Appointment;
import monportfolio.portfoliobackend.repository.AppointmentRepository;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;
    private final SimpMessagingTemplate messagingTemplate;

    public AppointmentService(AppointmentRepository repository, SimpMessagingTemplate messagingTemplate) {
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
    }

    public Appointment create(Appointment appointment) {
        if (!isSlotAvailable(appointment.getScheduledAt())) {
            throw new IllegalArgumentException("Ce créneau est déjà réservé.");
        }

        Appointment saved = repository.save(appointment);
        messagingTemplate.convertAndSend("/topic/appointments", saved);
        return saved;
    }

    public List<Appointment> getAll() {
        return repository.findAll();
    }

    public Appointment updateStatus(Long id, Appointment.Status status) {
        Appointment appt = repository.findById(id).orElseThrow();
        appt.setStatus(status);
        return repository.save(appt);
    }

    @Scheduled(cron = "0 0 * * * *")
    public void removePastAppointments() {
        List<Appointment> all = repository.findAll();
        for (Appointment appt : all) {
            if (appt.getScheduledAt().isBefore(LocalDateTime.now())) {
                repository.delete(appt);
            }
        }
        System.out.println("[CRON] Appointments passés supprimés");
    }

    public boolean isSlotAvailable(LocalDateTime slot) {
        return repository.findAll().stream()
                .noneMatch(a -> a.getScheduledAt().equals(slot));
    }
}
