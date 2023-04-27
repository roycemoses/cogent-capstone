package doConnect.cogentcapstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private UserRepository userRepository;

	@GetMapping("/test")
	public String home() {
		return "This is home";
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
}
