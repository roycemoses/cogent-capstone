package doConnect.cogentcapstone.controller;

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

import doConnect.cogentcapstone.entity.Answer;
import doConnect.cogentcapstone.entity.User;
import doConnect.cogentcapstone.mail.EmailUtil;
import doConnect.cogentcapstone.service.AnswerService;
import doConnect.cogentcapstone.service.UserService;


@Controller
@ResponseBody
@CrossOrigin("*")
//@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService atr;
    @Autowired
    UserService utr;
    
    //add
    @PostMapping(value={"/addanswer"})
    public Answer addAnswer(@RequestBody @Validated Answer a) {
        Answer returnAnswer = atr.update(a);
    	Optional<Answer> o = getAnswerbyId(returnAnswer.getId());
        
        List<User> admins = utr.getAllUsersByUserType("admin");
        
        for (User temp : admins) {
            EmailUtil.infoEmailA(temp.getEmail(),o);
        }
        return returnAnswer;
    }
    
    //update
    @PutMapping(value={"/updateanswer"})
    public Answer updateAnswer(@RequestBody Answer a) {
        return atr.update(a);
    }
    
    
    //deletebyID
    @DeleteMapping(value={"/deleteanswer/{id}"})
    public void deleteAnswerbyId(@PathVariable("id") Integer id) {
            Optional<Answer> a = atr.getById(id);
            atr.delete(a.get());
	}
    
    
    //getAll
    @GetMapping("/getallanswer")
    public List<Answer> getAllAnswer() {
        List<Answer> a = atr.getAll();
        System.out.println("all as: " + a.size());
        return a;
    }
    
    //getAllFalse
    @GetMapping(value={"/getallanswerfalse"})
    public List<Answer> getAllAnswerFalse() {
        List<Answer> a = atr.getByStatus("denied");
        System.out.println("all denied as: " + a.size());
        return a;
    }
    
    
    //getbyQuestionID
    @GetMapping("/getanswerbyquestionid/{questionid}")
    public List<Answer> getAnswerbyQuestionId(@PathVariable("questionid") Integer id) {
        List<Answer> a = atr.getByquestion_id(id);
        System.out.println("all as for question " + id + ": " + a.size());
        return a;
    }
    
    
    //getbyID
    @GetMapping(value={"/getanswerbyid/{id}"})
    public Optional<Answer> getAnswerbyId(@PathVariable("id") Integer id) {
        Optional<Answer> a = atr.getById(id);
        return a;
    }
    
    //email //question or answerid
    @GetMapping(value={"/sendemail/{id}"})
    public void SendEmails(@PathVariable("id") Integer id) {
        
        Optional<Answer> o = getAnswerbyId(id);
        
        List<User> admins = utr.getAllUsersByUserType("admin");
        
        
        for (User temp : admins) {
            EmailUtil.infoEmailA(temp.getEmail(),o);
        }
        
    }
}

        /*
	@GetMapping("/getAllAnswers")
	public List<Answer> getAllAnswers()
	{
		return answerRepository.findAll();
	}
	
	@GetMapping("/getAllAnswerFalse")
	public List<Answer> getAllAnswersFalse()
	{
		List<Answer> answers = answerRepository.findAll();
		List<Answer> answersFalse = new ArrayList<Answer>();
		for (int i = 0; i < answers.size(); i++)
			if (answers.get(i).getStatus() != "accepted")
				answersFalse.add(answers.get(i));

		return answersFalse;
	}
	
	@PostMapping("/addAnswer")
	public Answer addAnswer(@Validated @ReauestBody Answer answer)
	{
		return answerRepository.save(answer);
	}
	
	@GetMapping("/getAnswerById")
	public Answer getAnswerById(Integer id)
	{
		return answerRepository.getById(id);
	}
	
	@PutMapping("/updateAnswer")
	public void updateAnswer(@Validated @ReauestBody Answer answer)
	{
		answerRepository.save(answer);
	}
	
	@DeleteMapping("deleteAnswerById/id={answerId}")
	public void deleteAnswer(@PathVariable Integer answerId)
	{
		answerRepository.deleteById(answerId);
	}
	
	@GetMapping("getAnswersByAnswerId/id={answerId}")
	public List<Answer> getAnswersByAnswerId(@PathVariable Integer answerId)
	{
		List<Answer> answers = answerRepository.findAll();
		List<Answer> answersWithAnswerId = new ArrayList<>();
		for (int i = 0; i < answers.size(); i++)
			if (answers.get(i).getAnswer().getId() == answerId)
				answersWithAnswerId.add(answers.get(i));
		
		return answersWithAnswerId;
	}
        */

