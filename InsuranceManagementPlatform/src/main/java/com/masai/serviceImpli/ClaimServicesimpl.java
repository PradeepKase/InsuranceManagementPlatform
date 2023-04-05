package com.masai.serviceImpli;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.ClaimRepo;
import com.masai.exceptions.ClaimNotFoud;
import com.masai.models.Claim;
import com.masai.services.ClaimServices;

@Service
public class ClaimServicesimpl implements ClaimServices {

	@Autowired
	private ClaimRepo claimrepo;

	@Override
	public Claim registerClaim(Claim c) {
		// TODO Auto-generated method stub
		Claim savedclaim = claimrepo.save(c);
		return savedclaim;
	}

	@Override
	public List<Claim> getListOfClaim() throws ClaimNotFoud {
		// TODO Auto-generated method stub
		List<Claim> list = claimrepo.findAll();
		if (list.size() == 0) {
			throw new ClaimNotFoud("the claim list is empty");
		} else {
			return list;
		}
	}

	@Override
	public Claim getClainmyid(Long id) throws ClaimNotFoud {
		// TODO Auto-generated method stub
		// funstional programming
		return claimrepo.findById(id).orElseThrow(() -> new ClaimNotFoud("claim not found with this " + id));
	}

//	@Override
//	public Claim updateClaim(Claim c) throws ClaimNotFoud {
//		// TODO Auto-generated method stub
//		Optional<Claim> opt = claimrepo.findById(c.getId());
//		if (opt.isPresent()) {
//			Claim updatedClaim = claimrepo.save(c);
//			return updatedClaim;
//		} else {
//			throw new ClaimNotFoud("claim not updated");
//		}
//	}

	@Override
	public Claim deletbyid(Long id) throws ClaimNotFoud {
		// TODO Auto-generated method stub
		Optional<Claim> opt = claimrepo.findById(id);
		if (opt.isPresent()) {
			Claim claim = opt.get();
			claimrepo.delete(claim);
			return claim;
		} else {
			throw new ClaimNotFoud("claim not present so cant delet by this id" + id);
		}
	}

	@Override
	public Claim updateClaim(Claim c) throws ClaimNotFoud {
		// TODO Auto-generated method stub
		Optional<Claim> opt = claimrepo.findById(c.getId());
		if (opt.isPresent()) {
			Claim updatedClaim = claimrepo.save(c);
			return updatedClaim;
		} else {
			throw new ClaimNotFoud("claim not updated");
		}
	}

}
