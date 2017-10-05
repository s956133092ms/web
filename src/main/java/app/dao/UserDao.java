package app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.user.User;
@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer>{
	
	List<User> findByWebname(String webname);
	
	User findByVideoname(String videoname);
	
	List<User> findByWebnameAndVideoname(String webname,String videoname);
	
	

}
