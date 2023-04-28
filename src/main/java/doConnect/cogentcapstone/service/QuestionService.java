/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doConnect.cogentcapstone.service;

import doConnect.cogentcapstone.entity.Question;
import doConnect.cogentcapstone.repository.QuestionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author willbarnes
 */
@Service
public class QuestionService {
    @Autowired
    QuestionRepository qtr;
    
    //Get all qs
    public List<Question> getAll(){
        return (List<Question>) qtr.findAll();
    }

    //Single Question get
    public Optional<Question> getById(int qId){
        return qtr.findById(qId);
    }
    
    //getbytopic
    public List<Question> getByTopic(String topic) {
        return qtr.findByTopic(topic);
    }
    
    public List<Question> getByStatus(String status) {
        return qtr.findByStatus(status);
    }
    
    //Update/create q
    public Question update(Question q) {
            return qtr.save(q);
    }
    //Delete q
    public void delete(Question q) {
            qtr.delete(q);
    }
    //Delete all qs
    public void deleteAll() {
            qtr.deleteAll();
    }
    
}
