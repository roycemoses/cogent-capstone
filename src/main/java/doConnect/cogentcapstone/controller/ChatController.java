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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@RestController
@CrossOrigin("*")
//@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/chat")
public class ChatController {

	
	// TODO: move this functionality to AnswerService class
	@Autowired
	private ChatService cts;

	@PostMapping("addMessage")
	public Chat addMessage(@Validated @RequestBody Chat chat)
	{
		return cts.update(chat);
	}
	
	@DeleteMapping("deleteChatById/{id}")
	public void deleteChatById(@PathVariable("id") Integer id)
	{
		cts.deleteByID(id);
                System.out.println("deleted.");
	}
	
        
	@GetMapping("getAllMessagesBetweenUsers/{userName1}/{userName2}")
	public List<Chat> getAllMessagesBetweenUsers(@PathVariable("userName1") String userName1, @PathVariable("userName2") String userName2)
	{
            List<Chat> from_user1 = cts.getByfromUser(userName1);
            List<Chat> from_user2 = cts.getByfromUser(userName2);
            List<Chat> to_user1 = cts.getBytoUser(userName1);
            List<Chat> to_user2 = cts.getBytoUser(userName2);
            ArrayList<Chat> all = new ArrayList<>();
            
            for (Chat c : from_user1) {
                if (c.getToUser().equals(userName2)) {
                    all.add(c);
                }
            }
            
            for (Chat c : from_user2) {
                if (c.getToUser().equals(userName1)) {
                    all.add(c);
                }
            }
            
            class sortByDateTime implements Comparator<Chat>
            {
            	@Override
            	public int compare(Chat o1, Chat o2) {
            		if (o1.getDatetime().compareTo(o2.getDatetime()) < 0)
            			return -1;
            		if (o1.getDatetime().compareTo(o2.getDatetime()) > 0)
            			return 1;
            		return 0;
            	}
            }
            
            Collections.sort(all, new sortByDateTime());
                
            return all;
	}

        @GetMapping("getAllChatMessages")
        public List<Chat> getAllChatMessages() {
            return cts.getAllChatMessages();
        }
}
