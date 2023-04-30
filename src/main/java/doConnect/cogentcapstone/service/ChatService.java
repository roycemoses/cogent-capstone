package doConnect.cogentcapstone.service;

import doConnect.cogentcapstone.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doConnect.cogentcapstone.repository.ChatRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    ChatRepository ctr;

//	addMessage()
    public Chat update(Chat c) {
            return ctr.save(c);
    }
    
//	deleteChatById
    public void deleteByID(int cId){
        ctr.deleteById(cId);  //i think this works
    }
    
    //	getAllChatMessagesLeft to and from 2 users?
    public List<Chat> getBytoUser(String toUser) {
        return ctr.findBytoUser(toUser);
    }

    public List<Chat> getByfromUser(String fromUser) {
        return ctr.findByfromUser(fromUser);
    }
    
    public List<Chat> getAllChatMessages() {
        return ctr.findAll();
    }
    
}
