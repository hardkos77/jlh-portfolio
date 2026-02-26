package monportfolio.portfoliobackend.service;

import monportfolio.portfoliobackend.entity.Skill;
import monportfolio.portfoliobackend.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository repository;

    public SkillService(SkillRepository repository) {
        this.repository = repository;
    }

    public List<Skill> getAll() {
        return repository.findAll();
    }
}
