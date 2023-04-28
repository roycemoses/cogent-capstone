package doConnect.cogentcapstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doConnect.cogentcapstone.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	AnswerRepository repo;

	
}
