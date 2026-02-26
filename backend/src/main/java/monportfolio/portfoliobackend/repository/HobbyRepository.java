package monportfolio.portfoliobackend.repository;

import monportfolio.portfoliobackend.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
