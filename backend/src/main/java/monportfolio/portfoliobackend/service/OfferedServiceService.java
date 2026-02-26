package monportfolio.portfoliobackend.service;

import monportfolio.portfoliobackend.entity.OfferedService;
import monportfolio.portfoliobackend.repository.OfferedServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferedServiceService {

    private final OfferedServiceRepository repository;

    public OfferedServiceService(OfferedServiceRepository repository) {
        this.repository = repository;
    }

    public List<OfferedService> getAll() {
        return repository.findAll();
    }
}
