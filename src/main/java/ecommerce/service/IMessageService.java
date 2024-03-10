package ecommerce.service;

import ecommerce.entity.Message;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMessageService {

    Message saveMes(Message message);
    List<Message> findBySenIdAndRecId(Long idSend, Long idRec);
    List<Message> findLastMessagesByChatPartners(Long id);

}
