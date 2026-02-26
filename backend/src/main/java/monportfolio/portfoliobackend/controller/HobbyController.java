package monportfolio.portfoliobackend.controller;

import monportfolio.portfoliobackend.entity.Hobby;
import monportfolio.portfoliobackend.service.HobbyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hobbies")
@CrossOrigin("*")
public class HobbyController {

    private final HobbyService service;

    public HobbyController(HobbyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Hobby> getAllHobbies() {
        return service.getAll();
    }
}
