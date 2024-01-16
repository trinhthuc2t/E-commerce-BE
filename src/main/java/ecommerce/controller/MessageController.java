package ecommerce.controller;
import ecommerce.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class MessageController {

@MessageMapping("/message")
    public void message(Message message){


}
}
