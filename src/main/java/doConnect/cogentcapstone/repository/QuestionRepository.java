package doConnect.cogentcapstone.repository;

import doConnect.cogentcapstone.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doConnect.cogentcapstone.entity.User;
@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    
}

