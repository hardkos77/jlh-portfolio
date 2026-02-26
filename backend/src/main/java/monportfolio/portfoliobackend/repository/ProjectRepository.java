package monportfolio.portfoliobackend.repository;

import monportfolio.portfoliobackend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
