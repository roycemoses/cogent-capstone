package doConnect.cogentcapstone.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doConnect.cogentcapstone.entity.Answer;
import doConnect.cogentcapstone.repository.AnswerRepository;
import doConnect.cogentcapstone.service.AnswerService;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/answer")
public class AnswerController {

	
	// TODO: move this functionality to AnswerService class
	@Autowired
	private AnswerRepository answerRepository; 
	@Autowired
	private AnswerService answerService;

	@GetMapping("/")
	public String home() {
		return "This is home";
	}
	
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
	public Answer addAnswer(@Validated @RequestBody Answer answer)
	{
		return answerRepository.save(answer);
	}
	
	@GetMapping("/getAnswerById")
	public Answer getAnswerById(Integer id)
	{
		return answerRepository.getById(id);
	}
	
	@PutMapping("/updateAnswer")
	public void updateAnswer(@Validated @RequestBody Answer answer)
	{
		answerRepository.save(answer);
	}
	
	@DeleteMapping("deleteAnswerById/id={answerId}")
	public void deleteAnswer(@PathVariable Integer answerId)
	{
		answerRepository.deleteById(answerId);
	}
	
	@GetMapping("getAnswersByQuestionId/id={questionId}")
	public List<Answer> getAnswersByQuestionId(@PathVariable Integer questionId)
	{
		List<Answer> answers = answerRepository.findAll();
		List<Answer> answersWithQuestionId = new ArrayList<>();
		for (int i = 0; i < answers.size(); i++)
			if (answers.get(i).getQuestion().getId() == questionId)
				answersWithQuestionId.add(answers.get(i));
		
		return answersWithQuestionId;
	}
}
