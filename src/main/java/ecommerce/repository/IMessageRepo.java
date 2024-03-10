package ecommerce.repository;

import ecommerce.entity.Account;
import ecommerce.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMessageRepo extends JpaRepository<Message, Long> {
    @Query("SELECT m from Message m WHERE m.sender.id = :senderId AND m.receiver.id = :receiverId" +
            " OR m.sender.id = :receiverId AND m.receiver.id = :senderId order by m.createAt")
    List<Message> findBySenIdAndRecId(@Param("senderId") Long senderId, @Param("receiverId") Long receiverId);



    @Query("SELECT m FROM Message m " +
            "WHERE (m.sender.id = :id OR m.receiver.id = :id) " +
            "AND m.createAt = (SELECT MAX(m2.createAt) FROM Message m2 " +
            "WHERE (m2.sender.id = m.sender.id AND m2.receiver.id = m.receiver.id) " +
            "   OR (m2.sender.id = m.receiver.id AND m2.receiver.id = m.sender.id)) ORDER BY m.createAt DESC ")
    List<Message> findLastMessagesByChatPartners(@Param("id") Long id);
}