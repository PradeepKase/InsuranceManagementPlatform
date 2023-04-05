package com.masai.serviceImpli;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.InsurancePolicyRepo;
import com.masai.exceptions.InsurancePolicyNotFound;
import com.masai.models.InsurancePolicy;
import com.masai.services.InsurancePolicyServices;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyServices{

	@Autowired
	private InsurancePolicyRepo insurancepolicyrepo;
	
	
	@Override
	public InsurancePolicy saveInsurencePolicy(InsurancePolicy insurance) {
		// TODO Auto-generated method stub
		InsurancePolicy ins= insurancepolicyrepo.save(insurance);
		return ins;
	}

	@Override
	public InsurancePolicy getInsurancePolicyByid(Long id) throws InsurancePolicyNotFound {
		// TODO Auto-generated method stub
		return insurancepolicyrepo.findById(id).orElseThrow(()-> new InsurancePolicyNotFound("insurance not found with this "+id));
		
	}

	@Override
	public List<InsurancePolicy> getListOfPolcies() throws InsurancePolicyNotFound {
		// TODO Auto-generated method stub
		List<InsurancePolicy> list=insurancepolicyrepo.findAll();
		if(list.size()==0) {
			throw new InsurancePolicyNotFound("there is no list");
		}else {
			return list;
		}
	}

	@Override
	public InsurancePolicy deleteById(Long id) throws InsurancePolicyNotFound {
		// TODO Auto-generated method stub
		Optional<InsurancePolicy>opt= insurancepolicyrepo.findById(id);
		if(opt.isPresent()) {
			InsurancePolicy insu=opt.get();
			insurancepolicyrepo.delete(insu);
			return insu;
		}else {
			throw new InsurancePolicyNotFound("cant delet with this "+id);
		}
	}

	@Override
	public InsurancePolicy updateinsurance(InsurancePolicy insurance) throws InsurancePolicyNotFound {
		// TODO Auto-generated method stub
		Optional<InsurancePolicy>opt= insurancepolicyrepo.findById(insurance.getId());
		if(opt.isPresent()) {
			InsurancePolicy insurancepolicy= insurancepolicyrepo.save(insurance);
			return insurancepolicy;
		}else {
			throw new InsurancePolicyNotFound("not updated");
		}
	}
	


}
