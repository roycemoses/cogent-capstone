package doConnect.cogentcapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import doConnect.cogentcapstone.entity.Answer;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    List<Answer> findByquestion_id(int question_id);
    List<Answer> findByStatus(String status);
}

