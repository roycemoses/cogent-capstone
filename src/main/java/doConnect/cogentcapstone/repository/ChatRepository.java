package doConnect.cogentcapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import doConnect.cogentcapstone.entity.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer> {
    
}

