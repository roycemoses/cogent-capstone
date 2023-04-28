package doConnect.cogentcapstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import doConnect.cogentcapstone.entity.AuthRequest;
import doConnect.cogentcapstone.entity.User;
import doConnect.cogentcapstone.repository.UserRepository;
import doConnect.cogentcapstone.service.UserService;
import doConnect.cogentcapstone.util.JwtUtil;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins="http://localhost:4200/")
//@RequestMapping("/User")
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/test")
	public String home() {
		return "This is home";
	}
	
	@GetMapping("/logins")
	public List<User> getLogins() {
		return userRepository.findAll();
	}
		
	@GetMapping("/getbyname={userName}")
	public User getUser(@PathVariable String userName) {
		return userRepository.findByUserName(userName);
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}
	
	@PutMapping("/User/adduser")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		return "User with name "+ user.getName()+" was saved.";
	}
	
	@PutMapping("/User/updateuser")
	public String updateUser(@RequestBody User user) {
		//userRepository.save(user);
		return "User updated";
	}
	
	@GetMapping("/User/getbyallUserType")
	public List<User> getUserByUserType(@PathVariable String userType) {
		return userService.getAllUsersByUserType(userType);
	}
}
