package doConnect.cogentcapstone;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import doConnect.cogentcapstone.entity.User;
import doConnect.cogentcapstone.repository.UserRepository;

@SpringBootApplication
public class CogentCapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CogentCapstoneApplication.class, args);
	}
	
	@Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "Gyanendra", "gyanendra", "password", "gsytec@gmail.com", "admin"),
                new User(102, "User1", "user1", "pwd1", "user1@gmail.com", "user"),
                new User(103, "User2", "user2", "pwd2", "user2@gmail.com", "user"),
                new User(104, "User3", "user3", "pwd3", "user3@gmail.com", "user")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
	
}
