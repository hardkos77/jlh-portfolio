package monportfolio.portfoliobackend.service;

import monportfolio.portfoliobackend.entity.Hobby;
import monportfolio.portfoliobackend.repository.HobbyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {

    private final HobbyRepository repository;

    public HobbyService(HobbyRepository repository) {
        this.repository = repository;
    }

    public List<Hobby> getAll() {
        return repository.findAll();
    }
}
