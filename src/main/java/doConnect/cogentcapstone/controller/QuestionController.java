/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doConnect.cogentcapstone.controller;

import doConnect.cogentcapstone.CogentCapstoneApplication;
import doConnect.cogentcapstone.entity.Answer;
import doConnect.cogentcapstone.entity.Question;
import doConnect.cogentcapstone.entity.User;
import doConnect.cogentcapstone.mail.EmailUtil;
import doConnect.cogentcapstone.service.QuestionService;
import doConnect.cogentcapstone.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author willbarnes
 */
@Controller
@ResponseBody
@CrossOrigin("*")
//@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService qtr;
    @Autowired
    UserService utr;

    
    //add
    @PostMapping(value={"/addquestion"})
    public Question addQuestion(@RequestBody @Validated Question q) {
    	q.setImage_src(q.getImage_src().replace("C:\\fakepath\\", "assets/"));
    	Question returnQuestion = qtr.update(q);
    	Optional<Question> o = getQuestionbyId(returnQuestion.getId());
        
        List<User> admins = utr.getAllUsersByUserType("admin");
        
        for (User temp : admins) {
            EmailUtil.infoEmailQ(temp.getEmail(),o);
        }
        
        
        return returnQuestion;
    }
    
    //update
    @PutMapping(value={"/updatequestion"})
    public Question updateQuestion(@RequestBody Question q) {
        return qtr.update(q);
    }
    
    //deletebyID
    @DeleteMapping(value={"/deletequestion/{id}"})
    public void deleteQuestionbyId(@PathVariable("id") Integer id) {
            Optional<Question> q = qtr.getById(id);
            qtr.delete(q.get());
//            return "Question id "+id+" deleted successfully";
	}
    
    
    //getAll
    @GetMapping("/getallquestion")
    public List<Question> getAllQuestion() {
        List<Question> q = qtr.getAll();
        System.out.println("all qs: " + q.size());
        return q;
    }
    
    //getAllFalse
    @GetMapping("/getallquestionfalse")
    public List<Question> getAllQuestionFalse() {
        List<Question> q = qtr.getByStatus("denied");
        System.out.println("all denied qs: " + q.size());
        return q;
    }
    
    //getbyTopic
    @GetMapping(value={"/getquestionbytopic/{topic}"})
    public List<Question> getQuestionbyTopic(@PathVariable("topic") String topic) {
        List<Question> q = qtr.getByTopic(topic);
        System.out.println("all qs with this topic: " + q.size());
        return q;
    }
    
    //getbyID
    @GetMapping(value={"/getquestionbyid/{id}"})
    public Optional<Question> getQuestionbyId(@PathVariable("id") Integer id) {
        Optional<Question> q = qtr.getById(id);
        return q;
    }
    
  
    //email //question or answerid
//    @PostMapping(value={"/sendemail/{id}"})
//    public void SendEmails(@PathVariable("id") Integer id) {
//        System.out.println("im trying to send an email");
//        Optional<Question> o = getQuestionbyId(id);
//        
//        List<User> admins = utr.getAllUsersByUserType("admin");
//        
//        
//        for (User temp : admins) {
//            EmailUtil.infoEmailQ(temp.getEmail(),o);
//        }
//    }
    
}
