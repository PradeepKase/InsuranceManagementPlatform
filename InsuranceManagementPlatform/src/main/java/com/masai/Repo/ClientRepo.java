package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ch.qos.logback.core.net.server.Client;

@Repository
public interface ClientRepo extends JpaRepository<com.masai.models.Client, Long>{
	
}
