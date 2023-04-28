package doConnect.cogentcapstone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import doConnect.cogentcapstone.entity.User;
import doConnect.cogentcapstone.repository.UserRepository;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	UserRepository utr;

	@Override //server stuff
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=utr.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}
        
        //add user
	public User addUser(User user) {
		return utr.save(user);
	}
	
        //addnewuser ??
        
        //getlogin ?
        
        //get all
        public List<User> getAll() {
            return utr.findAll();
        }
        
        //get by id
        public Optional<User> getbyId(int id) {
            return utr.findById(id);
        }
        
        //update user
        public User update(User u) {
            return utr.save(u);
        }
        
        //get by username
        public User getbyUserName(String username) {
            return utr.findByUserName(username);
        }
	
        //get by user type
	public List<User> getAllUsersByUserType(String userType) {
		return utr.findAllByUserType(userType);
	}
        
        //userloginverify
	
        //get by boolean loggedin
        public List<User> getByislogged(boolean islogged) {
            return utr.findByislogged(islogged);
        }
	
}
