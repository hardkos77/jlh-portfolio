package monportfolio.portfoliobackend.service;

import monportfolio.portfoliobackend.entity.Message;
import monportfolio.portfoliobackend.repository.MessageRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Service
public class MessageService {

    private final MessageRepository repository;
    private final SimpMessagingTemplate messagingTemplate;

    public MessageService(MessageRepository repository, SimpMessagingTemplate messagingTemplate) {
        this.repository = repository;
        this.messagingTemplate = messagingTemplate;
    }

    public Message saveMessage(Message message) {
        Message saved = repository.save(message);
        notifyAdmin(saved);
        return saved;
    }

    @Async
    public void notifyAdmin(Message message) {
        System.out.println("📩 Message reçu : " + message.getSenderName());

        // Envoi d'une notif WebSocket à /topic/messages
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
