package org.ac.cst8277.mesak.nermeen.services;

import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.Role;
import org.ac.cst8277.mesak.nermeen.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
	@Autowired
	RoleRepository roleRepository;


	
	@Override
	public void addRole(Role role) {
		this.roleRepository.save(role);
	}
	
	
	
	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	
	
	
	@Override
	public Role getRoleById(long id) {
		return roleRepository.findById(id).get();
	}

	
	
	
	@Override
	public void deleteRole(long id) {
		roleRepository.deleteById(id);
	}

}
