package doConnect.cogentcapstone.repository;

import doConnect.cogentcapstone.entity.Answer;
import doConnect.cogentcapstone.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    
    List<Question> findByTopic(String topic);
    List<Question> findByStatus(String status);
}

