package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.InsurancePolicy;
@Repository
public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy, Long>{

}
