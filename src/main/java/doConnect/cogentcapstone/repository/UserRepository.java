package doConnect.cogentcapstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doConnect.cogentcapstone.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	User findByUserName(String username);
	List<User> findAllByUserType(String userType);
}
