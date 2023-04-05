package com.masai.services;

import java.util.List;
import com.masai.exceptions.InsurancePolicyNotFound;
import com.masai.models.InsurancePolicy;

public interface InsurancePolicyServices {

	public InsurancePolicy saveInsurencePolicy(InsurancePolicy insurance);
	
	public InsurancePolicy getInsurancePolicyByid(Long id)throws InsurancePolicyNotFound;
	
	public List<InsurancePolicy> getListOfPolcies()throws InsurancePolicyNotFound;
	
	public InsurancePolicy deleteById(Long id) throws InsurancePolicyNotFound;
	
	public InsurancePolicy updateinsurance(InsurancePolicy insurance)throws InsurancePolicyNotFound;
}
