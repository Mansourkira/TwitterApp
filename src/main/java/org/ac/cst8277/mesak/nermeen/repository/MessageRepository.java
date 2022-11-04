package org.ac.cst8277.mesak.nermeen.repository;

import org.ac.cst8277.mesak.nermeen.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	
}
