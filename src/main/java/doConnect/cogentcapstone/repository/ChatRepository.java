package doConnect.cogentcapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import doConnect.cogentcapstone.entity.Chat;
import java.util.List;
import org.springframework.data.repository.query.Param;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer> {
    
     List<Chat> findBytoUser(String toUser);
     List<Chat> findByfromUser(String fromUser);

    
//    List<Chat> findBytoUser(String toUser);
//    List<Chat> findByfromUser(String fromUser);
}


