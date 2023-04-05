package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Claim;

@Repository
public interface ClaimRepo extends JpaRepository<Claim, Long>{

}
