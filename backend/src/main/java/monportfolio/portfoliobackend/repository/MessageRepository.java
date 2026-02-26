package monportfolio.portfoliobackend.repository;

import monportfolio.portfoliobackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}