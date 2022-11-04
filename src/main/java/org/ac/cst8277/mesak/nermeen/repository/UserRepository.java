package org.ac.cst8277.mesak.nermeen.repository;

import java.util.List;
import java.util.Optional;

import org.ac.cst8277.mesak.nermeen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	@Query(value = "SELECT\n"
			+ "`users`.`id`,\n"
			+ "`users`.`email`\n"
			+ "FROM\n"
			+ "`users`\n"
			+ "LEFT JOIN `user_roles` on `users`.`id` = `user_roles`.`user_id`\n"
			+ "LEFT JOIN `roles` on `user_roles`.`role_id` = `roles`.`id`\n"
			+ "WHERE\n"
			+ "`roles`.`name` =  %?1%", nativeQuery = true)
	List<User> findByTitleAndSortNative(String title);
}
