package com.masai.services;

import java.util.List;

import com.masai.exceptions.ClaimNotFoud;
import com.masai.models.Claim;

public interface ClaimServices {

	public Claim registerClaim(Claim c);
		
	public List<Claim> getListOfClaim() throws ClaimNotFoud;
	
	public Claim getClainmyid(Long id) throws ClaimNotFoud;
	
	public Claim updateClaim(Claim  c) throws ClaimNotFoud;
	
	public Claim deletbyid(Long id) throws ClaimNotFoud;

}
