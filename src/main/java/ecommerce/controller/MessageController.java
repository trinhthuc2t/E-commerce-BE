package ecommerce.controller;

import ecommerce.entity.Message;
import ecommerce.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    IMessageService messageService;

    @Autowired
    SimpMessagingTemplate template;

    @PostMapping("/message")
    public Message saveMes(@RequestBody Message message) {
        template.convertAndSend("/message", message);
        message.setCreateAt(LocalDateTime.now());
        return messageService.saveMes(message);
    }
    @GetMapping("/{senId}/{recId}")
    public List<Message> getMes(@PathVariable Long senId, @PathVariable Long recId) {
        return messageService.findBySenIdAndRecId(senId, recId);
    }
    @GetMapping("/account/{accId}/mes")
    public List<Message> findLastMessagesByChatPartners( @PathVariable Long accId) {
        return messageService.findLastMessagesByChatPartners(accId);
    }
}
