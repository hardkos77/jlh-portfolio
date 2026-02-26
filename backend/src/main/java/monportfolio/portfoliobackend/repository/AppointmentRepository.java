package monportfolio.portfoliobackend.repository;

import monportfolio.portfoliobackend.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
