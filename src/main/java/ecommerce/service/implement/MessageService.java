package ecommerce.service.implement;

import ecommerce.entity.Message;
import ecommerce.repository.IMessageRepo;
import ecommerce.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {
    @Autowired
    IMessageRepo messageRepo;

    @Override
    public Message saveMes(Message message) {
        return messageRepo.save(message);
    }

    @Override
    public List<Message> findBySenIdAndRecId(Long idSend, Long idRec) {
        return messageRepo.findBySenIdAndRecId(idSend,idRec);
    }

    @Override
    public List<Message> findLastMessagesByChatPartners(Long id) {
        return messageRepo.findLastMessagesByChatPartners(id);
    }
}
