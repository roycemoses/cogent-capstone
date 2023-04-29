package doConnect.cogentcapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doConnect.cogentcapstone.entity.Chat;
import doConnect.cogentcapstone.repository.ChatRepository;
import doConnect.cogentcapstone.service.ChatService;

@RestController
@CrossOrigin("*")
//@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/chat")
public class ChatController {

	
	// TODO: move this functionality to AnswerService class
	@Autowired
	private ChatRepository chatRepository; 
	@Autowired
	private ChatService chatService;

	@PostMapping("addMessage")
	public Chat addMessage(@Validated @RequestBody Chat chat)
	{
		return chatRepository.save(chat);
	}
	
	@DeleteMapping("deleteChatById/{id}")
	public void deleteChatById(@PathVariable("id") Integer id)
	{
		chatRepository.deleteById(id);
                System.out.println("deleted.");
	}
	
	@GetMapping("getAllChatMessages")
	public List<Chat> getAllChatMessages()
	{
		return chatRepository.findAll();
	}
}
