/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doConnect.cogentcapstone.mail;

import doConnect.cogentcapstone.entity.Answer;
import doConnect.cogentcapstone.entity.Question;
import doConnect.cogentcapstone.repository.UserRepository;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailUtil {

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
    
    public static final String familyGuy() {
        return "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣤⣶⣶⣶⣶⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
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
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠙⠛⠛⠛⠛⠛⠛⠿⠟⠛⠛⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
                
    }
    
    
          
        public static void infoEmailQ(String toEmail, Optional<Question> o) {
		final String fromEmail = "group5newmailbot@gmail.com"; //requires valid gmail id
		final String password = "zzrxjmzwjakafdwx"; // correct password for gmail id
		//final String toEmail = ""; // can be any email id 
		
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
		
                
		sendEmail(session, toEmail,
                        "Question " + o.get().getId() + " has been posted." , 
                 "congrats, view: http://localhost:4200/pending-questions " + o.get() + ", \n"
                         + familyGuy());
                
        }
               
        public static void infoEmailA(String toEmail, Optional<Answer> o) {
		final String fromEmail = "group5newmailbot@gmail.com"; //requires valid gmail id
		final String password = "zzrxjmzwjakafdwx"; // correct password for gmail id
		//final String toEmail = ""; // can be any email id 
		
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
		
                
		sendEmail(session, toEmail,
                        "Answer " + o.get().getId() + " in response to Question " + o.get().getQuestion().getId() + " has been posted." , 
                 "congrats, view: http://localhost:4200/pending-answers  " + o.get() + ", \n"
                         + familyGuy());
                
        }
    
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("group5newmailbot@gmail.com", "Group5 Mailbot"));

	      msg.setReplyTo(InternetAddress.parse("group5newmailbot@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
}