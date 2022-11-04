package org.ac.cst8277.mesak.nermeen.services;

import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.User;

public interface IUserService {

	void addUser(User user);

	List<User> getAllUser();

	User getUserById(long id);

	void deleteUser(long id);

}
