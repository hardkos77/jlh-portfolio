package monportfolio.portfoliobackend.controller;

import monportfolio.portfoliobackend.entity.Faq;
import monportfolio.portfoliobackend.service.FaqService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
@CrossOrigin("*")
public class FaqController {

    private final FaqService service;

    public FaqController(FaqService service) {
        this.service = service;
    }

    @GetMapping
    public List<Faq> getAllFaqs() {
        return service.getAllFaqs();
    }
}
