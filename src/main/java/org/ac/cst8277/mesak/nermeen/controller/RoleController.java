package org.ac.cst8277.mesak.nermeen.controller;

import java.util.List;

import org.ac.cst8277.mesak.nermeen.models.Role;
import org.ac.cst8277.mesak.nermeen.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
    private  RoleService roleService;

    @PostMapping("/addRole")
    
    public ResponseEntity<Role> addRole (@RequestBody Role role) {
        roleService.addRole(role);
        return ResponseEntity.ok().body(role);
    }

    @GetMapping("/getAllRole")
    public ResponseEntity<List<Role>> getAllRole() {
        return ResponseEntity.ok().body(roleService.getAllRole());
    }

    @GetMapping("/getRoleById/{id}")
    public ResponseEntity<Role> getUserById(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(roleService.getRoleById(id));
    }

    @DeleteMapping("/deleteRole/{id}")
    public void deleteRole(@PathVariable("id") int id) {
    	roleService.deleteRole(id);
    }
    
}
