package doConnect.cogentcapstone.service;

import doConnect.cogentcapstone.entity.Answer;
import doConnect.cogentcapstone.entity.Question;
import doConnect.cogentcapstone.repository.AnswerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author willbarnes
 */
@Service
public class AnswerService {
    @Autowired
    AnswerRepository atr;
    
    //Get all as
    public List<Answer> getAll(){
        return atr.findAll();
    }

    //Single Answer get
    public Optional<Answer> getById(int aId){
        return atr.findById(aId);
    }
    
    
    //getbyquestionid
    public List<Answer> getByquestion_id(int question_id) {
        return atr.findByquestion_id(question_id);
    }
    
    
    public List<Answer> getByStatus(String status) {
        return atr.findByStatus(status);
    }
    
    //Update/create a
    public Answer update(Answer a) {
            return atr.save(a);
    }
    //Delete a
    public void delete(Answer a) {
            atr.delete(a);
    }
    //Delete all as
    public void deleteAll() {
            atr.deleteAll();
    }
    
}

