package org.ac.cst8277.mesak.nermeen.services;

import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.User;
import org.ac.cst8277.mesak.nermeen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	@Autowired
	 UserRepository userRepository;

	@Override
	public void addUser(User user) {
		this.userRepository.save(user);
	}

	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	
	@Override
	public  User getUserById(long id) {
		return userRepository.findById(id).get();
	}

	
	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}


}
