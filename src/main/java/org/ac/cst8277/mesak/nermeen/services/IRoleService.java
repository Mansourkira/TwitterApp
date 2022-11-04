package org.ac.cst8277.mesak.nermeen.services;

import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.Role;

public interface IRoleService {

	void addRole(Role role);

	List<Role> getAllRole();

	void deleteRole(long id);

	Role getRoleById(long id);

}
