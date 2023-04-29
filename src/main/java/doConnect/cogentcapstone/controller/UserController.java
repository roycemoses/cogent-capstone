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
import java.util.Optional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
//@CrossOrigin("*")
@CrossOrigin(origins="http://localhost:4200/")
//@RequestMapping("/user")
public class UserController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService utr;

	@GetMapping("/test")
	public String home() {
		return "This is home";
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
        
        //add
        @PostMapping("/user/adduser")
        public User addUser(@RequestBody @Validated User u) {
            return utr.addUser(u);
        }
        
        //addnewuser ?? what is that
        
        //getlogin idk
        
        //getall
        @GetMapping("/user/getall")
        public List<User> getAllUsers() {
            return utr.getAll();
        }
        
        //getbyid
        @GetMapping("/user/getbyid/{id}")
        public Optional<User> getById(@PathVariable("id") Integer id) {
            return utr.getbyId(id);
        }
        
        //update
	@PutMapping("/user/updateuser")
	public User updateUser(@RequestBody User user) {
            System.out.println("User updated");
            return utr.update(user);
            
	}
	
        //getbyusername
	@GetMapping("/user/getbyname/{userName}")
	public User getUser(@PathVariable("userName") String userName) {
            return utr.getbyUserName(userName);
	}
        
        //getbyusertype or something
        @GetMapping("/user/getbyusertype/{userType}")
        public List<User> getByUserType(@PathVariable("userType") String userType) {
            return utr.getAllUsersByUserType(userType);
        }
        
        
        //userloginverify?
        // idk
	
}
