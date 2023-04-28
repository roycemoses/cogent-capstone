package doConnect.cogentcapstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import doConnect.cogentcapstone.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    
}

