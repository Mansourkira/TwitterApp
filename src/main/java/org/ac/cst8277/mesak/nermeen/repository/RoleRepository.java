package org.ac.cst8277.mesak.nermeen.repository;

import java.util.Optional;

import org.ac.cst8277.mesak.nermeen.models.ERole;
import org.ac.cst8277.mesak.nermeen.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
