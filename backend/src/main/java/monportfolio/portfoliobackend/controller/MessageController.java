package monportfolio.portfoliobackend.controller;

import monportfolio.portfoliobackend.entity.Message;
import monportfolio.portfoliobackend.service.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin("*")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @PostMapping
    public Message receiveMessage(@RequestBody Message message) {
        Message saved = service.saveMessage(message);
        service.notifyAdmin(saved); // Appel async
        return saved;
    }
}
