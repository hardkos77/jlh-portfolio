package monportfolio.portfoliobackend.controller;

import monportfolio.portfoliobackend.entity.Skill;
import monportfolio.portfoliobackend.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin("*")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return service.getAll();
    }
}
