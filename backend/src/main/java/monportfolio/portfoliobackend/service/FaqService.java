package monportfolio.portfoliobackend.service;

import monportfolio.portfoliobackend.entity.Faq;
import monportfolio.portfoliobackend.repository.FaqRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    private final FaqRepository repository;

    public FaqService(FaqRepository repository) {
        this.repository = repository;
    }

    public List<Faq> getAllFaqs() {
        return repository.findAll();
    }
}
