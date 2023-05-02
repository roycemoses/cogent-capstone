package doConnect.cogentcapstone;


import doConnect.cogentcapstone.entity.Answer;
import doConnect.cogentcapstone.entity.Chat;
import doConnect.cogentcapstone.entity.Question;
import doConnect.cogentcapstone.mail.EmailUtil;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import search_func.search;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import doConnect.cogentcapstone.entity.User;
import doConnect.cogentcapstone.repository.AnswerRepository;
import doConnect.cogentcapstone.repository.ChatRepository;
import doConnect.cogentcapstone.repository.QuestionRepository;
import doConnect.cogentcapstone.repository.UserRepository;
import java.util.ArrayList;

@SpringBootApplication
public class CogentCapstoneApplication implements WebMvcConfigurer {


                
                /**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 */
//	@Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins(
//                        "http://localhost:4200"
//                )
//                .allowedMethods(
//                        "GET",
//                        "PUT",
//                        "POST",
//                        "DELETE",
//                        "PATCH",
//                        "OPTIONS"
//                );
//    }
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowedOrigins("http://localhost:4200","http://localhost:8080");
        WebMvcConfigurer.super.addCorsMappings(registry);
    }
	public static void main(String[] args) {
            
            
            //search src = new search();
            //src.doSearch();
            
            
            
            
            SpringApplication.run(CogentCapstoneApplication.class, args);
            
	}
	

        
    @Autowired
    private UserRepository uRepo;
        
    @Autowired
    private QuestionRepository qRepo;
    
    @Autowired
    private AnswerRepository aRepo;
    
    @Autowired
    private ChatRepository cRepo;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User("Gyanendra", "gyanendra", "password", "group5newmailbot@gmail.com", "admin"),
                new User("User1", "user1", "pwd1", "group5newmailbot@gmail.com", "user"),
                new User("User2", "user2", "pwd2", "user2@gmail.com", "user"),
                new User("s", "s", "asdf", "user3@gmail.com", "admin"),
                new User("none", "none", "none", "none", "none")
        ).collect(Collectors.toList());
        uRepo.saveAll(users);
        
        
        //List<Answer> answers = new ArrayList<Answer>();
//        Question q1 = new Question(100,"i am bad at sqrts", "/assets/test_image1.png", "4/4/2004 22:22", "accepted", "math", "what is the sqrt4", new ArrayList<>(),"ok","hi");
//        Answer a1 = new Answer(1001,"it's 2","assets/test_image1.png","accepted","4/4/3004",q1,"ok","hi");
//        
//        q1.getAnswers().add(a1);
//        
//        
//        List<Question> questions = Stream.of(
//                new Question(100,"i am bad at sqrts", "/assets/test_image1.png", "4/4/2004 22:22", "accepted", "math", "what is the sqrt4", new ArrayList<>(), "ok", "hi"),
//                new Question(101,"q2", "q2", "q2", "accepted", "asdfgasfd", "whasdfaat is the sqrt4", new ArrayList<>(), "okasdf", "hadsfi"),
//                q1
//        ).collect(Collectors.toList());
//        qRepo.saveAll(questions);

        List<Answer> answers = new ArrayList<>();
        
        List<Question> questions = Stream.of(
                new Question("What is the capital city of France?", "assets/test_image1.png", "pending", "Geography", "French Capital", answers, "John Doe", "Jane Smith"),
                new Question("What are the three primary colors?", "assets/ss_comic.png", "accepted", "Art", "Primary Colors", answers, "Alice Lee", "Bob Johnson"),
                new Question("Who was the first president of the United States?", "", "pending", "History", "US President", answers, "Mary Kim", "Tom Chen"),
                new Question("What is the highest mountain in the world?", "", "accepted", "Geography", "Highest Mountain", answers, "Peter Brown", "Sarah Davis"),
                new Question("Who wrote the book 'To Kill a Mockingbird'?", "assets/ss_space.jpg", "pending", "Literature", "To Kill a Mockingbird", answers, "David Lee", "Susan Chang")
        ).collect(Collectors.toList());
        qRepo.saveAll(questions);
        
        answers = Stream.of(
                new Answer("The capital city of France is Paris.", "assets/test_image1.png", "accepted", qRepo.findById(users.size()+1).get(), "Jane Smith", "John Doe"),
                new Answer("The three primary colors are red, blue, and yellow.", "assets/ss_yoshigalint9.png", "accepted", qRepo.findById(users.size()+2).get(), "Bob Johnson", "Alice Lee"),
                new Answer("Red, blue, and yellow are the primary colors.", "", "accepted",  qRepo.findById(users.size()+2).get(),"Alice Lee", "Bob Johnson"),
                new Answer("George Washington was the first president of the United States.", "", "pending",  qRepo.findById(users.size()+3).get(), "Tom Chen", "Mary Kim"),
                new Answer("The first president of the United States was George Washington.", "", "accepted", qRepo.findById(users.size()+3).get(), "Mary Kim", "Tom Chen"),
                new Answer("Mount Everest is the highest mountain in the world.", "assets/ss_yoshigalint9.png", "pending", qRepo.findById(users.size()+4).get(), "Peter Brown", "Sarah Davis"),
                new Answer("Harper Lee wrote the book 'To Kill a Mockingbird'.", "assets/ss_yoshigalint9.png", "accepted", qRepo.findById(users.size()+5).get(), "Susan Chang", "David Lee"),
                new Answer("The author of 'To Kill a Mockingbird' is Harper Lee.", "", "pending", qRepo.findById(users.size()+5).get(), "David Lee", "Susan Chang")
        ).collect(Collectors.toList());
        aRepo.saveAll(answers);
        
        /*
        List<Answer> answers_temp = Stream.of(
                new Answer(1001,"it's 2","test_image1.png","accepted","4/4/3004",qRepo.findById(100).get(),"ok","hi")
        ).collect(Collectors.toList());
        aRepo.saveAll(answers_temp);
        
        qRepo.findById(100).get().setAnswers(answers_temp);
*/
        List<Chat> chats = Stream.of(
                new Chat(300,"gyanendra","user1","i like cats","4/4/4"),
                new Chat(301,"user1","gyanendra","i like dogs","4/4/4")
        ).collect(Collectors.toList());
        cRepo.saveAll(chats);
        
    }
	
}

