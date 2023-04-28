package doConnect.cogentcapstone;


import doConnect.cogentcapstone.entity.Answer;
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

import doConnect.cogentcapstone.entity.User;
import doConnect.cogentcapstone.repository.AnswerRepository;
import doConnect.cogentcapstone.repository.QuestionRepository;
import doConnect.cogentcapstone.repository.UserRepository;
import java.util.ArrayList;

@SpringBootApplication
public class CogentCapstoneApplication {


                
                /**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 */
	public static void main(String[] args) {
            
            
            //search src = new search();
            //src.doSearch();
            
            
            
            
            SpringApplication.run(CogentCapstoneApplication.class, args);
            
                /*
		final String fromEmail = "group5newmailbot@gmail.com"; //requires valid gmail id
		final String password = "zzrxjmzwjakafdwx"; // correct password for gmail id
		final String toEmail = "group5newmailbot@gmail.com"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail,"You Just Got Family Guy'd", 
                 "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣤⣶⣶⣶⣶⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⢿⣻⣿⣽⣯⣿⢯⣿⣟⣿⡿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⠿⠾⠿⠿⢷⡿⢋⡉⠉⠁⠀⠀⢀⠤⠉⠏⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢾⢹⡌⣿⣿⣧⡀⢀⠊⠁⠀⠀⠈⢢⢀⣀⠰⠁⠀⠀⢀⠈⢢⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠂⠀⠙⠀⠈⠉⠃⠀⢍⠀⠀⠀⠀⠛⠀⠇⠀⢃⠀⠀⠀⠈⠁⠸⠒⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠆⡀⠀⠀⠀⠜⠀⠀⠉⠀⠀⠁⠲⡔⠁⠀⠀⠀⠀⠐⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡴⡂⠈⠁⠀⠀⠠⡀⠀⠀⠀⠀⢀⠇⠀⠀⠀⠀⠀⠀⠈⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠢⢀⡀⠀⠈⠑⠒⠒⠒⠉⢰⡄⠀⠀⠀⠀⠀⠀⢰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠀⠐⠀⠀⠈⠁⠙⣢⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⠁⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣁⡀⠀⠀⠀⠀⠀⠀⠅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡅⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⢰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠊⢃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠢⢄⣀⡀⠴⠋⠑⠂⠤⠄⠒⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⢣⠀⠘⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠈⠀⠀⠡⡀⠀⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠌⠁⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠄⠀⠀⠑⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠊⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⡀⠁⠀⠀⠀⠀⠀⠀⠀⠈⠢⡀⠀⠀⠈⠢⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠊⠀⠀⢀⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠢⡀⠀⠀⠀⠑⠠⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠎⠀⠀⠀⡠⠁⠀⠀⠀⠂⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⢀⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⢀⠀⠀⠀⠀⠁⠀⠀⠠⢀⠀⠀⠀⠀⠀⠀⠀⢀⠠⠂⠁⠀⠀⠀⢀⠈⠀⠀⠀⠀⠀⠀⠡⡀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠠⡀⠀⠀⠀⠀⠀⠀⠀⡡⠶⠦⣀⢠⠖⠋⢄⠀⠀⠀⢀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⡀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⢀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠠⢀⠀⠀⠀⠎⠀⠀⢀⣈⡃⠀⠀⠈⢢⢀⠔⠁⠀⠀⠀⠀⠀⠀⠀⢁⠀⠀⠀⠐⡀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠐⠈⠀⠀⠀⠈⠊⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢠⠀⠀⠀⠠⠀⠀⠀⠀\n" +
"⠀⠇⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠱⡀⠀⠀⡃⠀⠀⠀\n" +
"⠠⠤⠀⠘⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢂⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡤⠊⠀⡠⡄⠀\n" +
"⠆⠀⠑⠀⠀⠑⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠒⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢶⠈⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡄⠀⠀⠆⠀\n" +
"⠘⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⣀⠀⠀⠀⢱⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣄⠚⠀⠀\n" +
"⠀⡏⢂⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡄⠃⠀\n" +
"⠀⡇⠀⠈⠆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠸⠀\n" +
"⢀⡇⠀⠀⠀⠀⠁⠂⠤⢀⡀⠀⠀⠀⠀⠀⣀⠐⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠀⡆\n" +
"⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠁⠀⠒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁\n" +
"⡇⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸\n" +
"⠇⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠆⠸\n" +
"⠈⠀⠰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠌⡆⡆\n" +
"⠀⠀⠱⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠃⣠⠰⠀\n" +
"⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠒⢡⠃⠀⠀⠀⠀⠀⠀⢀⣔⣁⣀⣤⣶⣿⡏⠉⠀⠁⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣶⣦⣤⣤⣄⣀⣨⣴⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡐⠁⠀⠀⢀⣀⣠⣴⣾⣿⢯⣿⣿⣿⣿⣿⠇⠀⠁⠀⠀\n" +
"⠀⢠⠈⠀⠀⢀⡴⠀⠀⠀⡀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⢯⣿⣿⣿⣿⣷⣶⣦⣤⣤⣤⣠⣄⣄⠀⠀⠠⠄⠂⠁⠉⠉⢿⣿⣿⣿⣿⣿⣿⣿⢯⣿⣟⣯⢷⡟⠀⠀⠀⠀⠀\n" +
"⠀⠐⠤⡠⠔⠉⠀⠀⢀⠞⠁⠀⢀⣼⣟⡾⣽⢯⣟⡿⣿⢿⣻⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⢀⣠⣿⣿⢿⣿⣻⢿⡽⣯⣟⡾⣽⣞⡿⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠁⠄⠀⠠⢶⡁⢀⣠⣴⢿⣻⢾⡽⣯⣟⡾⣽⢯⡿⡽⣯⢿⣹⢯⡿⣽⣻⡟⣿⣽⣻⢯⣟⡿⣷⡶⣤⣴⣶⣿⣻⡽⣞⡿⣞⡽⣯⣟⣳⢯⣟⣷⡞⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠹⣟⣯⣟⣯⢯⡿⣽⣳⢯⡿⣽⣛⡾⣽⢯⡿⣽⢯⣟⡷⣯⢟⣷⣛⣾⣻⢾⣽⣳⢿⣽⣳⣟⢾⣳⢿⡽⢯⣟⣽⣳⢯⣟⣻⡾⠉⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣞⡷⣯⢿⣽⣳⢯⡿⣽⣳⢯⡿⣽⢯⣟⣾⣻⢾⡽⢯⣟⡾⣽⢾⡽⣛⡾⣽⢯⣞⡷⣯⢿⡽⣻⣞⡿⣞⡷⣯⣟⡾⠏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢿⡽⣯⢾⡽⣯⢟⡷⣯⢿⡽⣏⡿⣞⣳⢯⡿⣽⣻⢾⡽⣯⠿⣽⢯⡿⣽⣻⢾⡽⣯⢯⣟⡷⣯⢿⡽⣽⣳⢯⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⡿⣽⣏⡿⣽⡽⣯⢿⡽⣻⢾⣽⣻⡽⣯⢿⣽⣳⢯⡿⣽⣫⢿⡽⣯⣟⣷⣿⣻⡽⣯⣟⡾⣽⢯⣷⣻⠷⣯⣟⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣹⣟⡷⣯⣟⣷⣻⡽⣯⢿⣽⣻⡞⣷⣻⡽⣯⢾⡽⣯⢟⡷⣯⣟⣿⢯⣟⡷⣯⢷⣻⣗⣯⢿⡽⣛⡾⣽⣻⢷⣫⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⢾⣽⣳⣞⡷⣯⢷⣯⣟⣾⢳⣟⡷⣯⢷⣯⠿⣽⣫⢿⣽⣳⢯⣟⡿⢾⡽⣏⣿⣳⢾⡽⣏⡿⣽⣻⣗⣯⣟⡷⣟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣻⡞⣷⢯⣟⣽⣻⢶⣻⣞⡿⢾⡽⣯⣟⣾⣻⢷⣯⣟⡾⣽⣻⢾⡽⣯⢿⡽⣾⢽⡯⢿⣽⣛⣷⣻⢞⣧⣟⡾⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⢷⣏⣿⣹⢿⡾⣷⣏⡿⣷⢏⡿⣏⡿⣷⣹⣾⣹⡾⣷⣾⣹⢷⣿⣏⣿⣹⡏⣿⡾⣏⡿⣿⡾⣹⣾⣹⢿⣾⡹⡿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣻⣞⡷⣯⢿⣹⢷⣫⢿⡽⣯⢿⡽⢯⣷⣻⢞⣷⣻⣗⣯⣽⣻⢾⡽⣞⣷⣻⢷⣻⡽⢯⣷⣻⠷⣯⢷⣻⢾⣽⣻⣽⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⣯⢷⣻⢾⡽⣯⣟⣯⣟⣯⢿⣹⢯⣟⡿⣞⣽⣻⣞⡷⣞⡷⣯⢷⣻⡿⣽⠾⣝⣯⢷⣻⣟⡾⣽⣻⣽⣯⣿⣽⣞⣷⣻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠐⣯⢿⡽⣯⣻⡵⣞⡷⣾⡽⢯⣟⣻⢾⣽⣻⣞⣷⣯⣿⣽⣯⡽⣯⢿⡽⣯⢿⡽⣞⣯⣷⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⢯⣟⡷⣯⢿⣽⣛⣷⣻⣟⣾⣽⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡽⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣻⢾⡽⣯⢷⡯⣟⣾⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠃⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠻⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠉⠉⠉⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠙⠛⠛⠛⠛⠛⠛⠿⠟⠛⠛⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
                );
                */
	}
	

        
    @Autowired
    private UserRepository uRepo;
        
    @Autowired
    private QuestionRepository qRepo;
    
    @Autowired
    private AnswerRepository aRepo;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "Gyanendra", "gyanendra", "password", "gsytec@gmail.com", "admin",true),
                new User(102, "User1", "user1", "pwd1", "user1@gmail.com", "user",false),
                new User(103, "User2", "user2", "pwd2", "user2@gmail.com", "user",true),
                new User(104, "User3", "user3", "pwd3", "user3@gmail.com", "user",false)
        ).collect(Collectors.toList());
        uRepo.saveAll(users);
        
        
        //List<Answer> answers = new ArrayList<Answer>();
        Question q1 = new Question(100,"i am bad at sqrts", "test_image1.png", "4/4/2004 22:22", "accepted", "math", "what is the sqrt4", new ArrayList<>(),"ok","hi");
        Answer a1 = new Answer(1001,"it's 2","test_image1.png","accepted","4/4/3004",q1,"ok","hi");
        
        q1.getAnswers().add(a1);
        
        
        List<Question> questions = Stream.of(
                q1
        ).collect(Collectors.toList());
        qRepo.saveAll(questions);
        
        
        
        /*
        List<Answer> answers_temp = Stream.of(
                new Answer(1001,"it's 2","test_image1.png","accepted","4/4/3004",qRepo.findById(100).get(),"ok","hi")
        ).collect(Collectors.toList());
        aRepo.saveAll(answers_temp);
        
        qRepo.findById(100).get().setAnswers(answers_temp);
*/
    }
	
}

