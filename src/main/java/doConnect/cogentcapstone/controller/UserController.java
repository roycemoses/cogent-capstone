package doConnect.cogentcapstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import doConnect.cogentcapstone.entity.AuthRequest;
import doConnect.cogentcapstone.entity.User;
import doConnect.cogentcapstone.repository.UserRepository;
import doConnect.cogentcapstone.util.JwtUtil;

@RestController
@CrossOrigin("*")
//@CrossOrigin(origins="http://localhost:4200/")
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository repo;

	@GetMapping("/authenticate")
	public String home() {
		return "This is home";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}
	
	@PostMapping("/addnewuser")
	public String addNewUser(@RequestBody User user) {
		repo.save(user);
		return "The user with name "+user.getName()+" has been saved.";
	}
}
