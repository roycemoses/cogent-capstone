package doConnect.cogentcapstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doConnect.cogentcapstone.repository.ChatRepository;

@Service
public class ChatService {

	@Autowired
	ChatRepository chatRepository;

//	addMessage()
//	deleteChatById
//	getAllChatMessagesLeft
}
