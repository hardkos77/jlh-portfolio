package monportfolio.portfoliobackend.controller;

import monportfolio.portfoliobackend.entity.OfferedService;
import monportfolio.portfoliobackend.service.OfferedServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@CrossOrigin("*")
public class OfferedServiceController {

    private final OfferedServiceService service;

    public OfferedServiceController(OfferedServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<OfferedService> getAllServices() {
        return service.getAll();
    }
}
