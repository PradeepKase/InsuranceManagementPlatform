package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.ClaimNotFoud;
import com.masai.models.Claim;
import com.masai.services.ClaimServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/InsurenceManagementPlatform")
public class ClaimController {

	@Autowired
	private ClaimServices claimservices;

	//http://localhost:8181/InsurenceManagementPlatform/POST/api/claims
	@PostMapping("/POST/api/claims")
	ResponseEntity<Claim> registerClaimHandler(@Valid @RequestBody Claim claim) {
		Claim c = claimservices.registerClaim(claim);
		return new ResponseEntity<Claim>(c, HttpStatus.CREATED);
	}

	//http://localhost:8181/InsurenceManagementPlatform/GET/api/claims/3
	@GetMapping("/GET/api/claims/{id}")
	ResponseEntity<Claim> getClaimByidHandler(@PathVariable("id") Long id) throws ClaimNotFoud {
		Claim c = claimservices.getClainmyid(id);
		return new ResponseEntity<Claim>(c, HttpStatus.OK);
	}

	//http://localhost:8181/InsurenceManagementPlatform/GET/api/claims
	@GetMapping("/GET/api/claims")
	ResponseEntity<List<Claim>> getListOfClaimHandler() throws ClaimNotFoud {
		List<Claim> list = claimservices.getListOfClaim();
		return new ResponseEntity<List<Claim>>(list, HttpStatus.OK);
	}

	
	//http://localhost:8181/InsurenceManagementPlatform/DELETE/api/claims/3
	@DeleteMapping("/DELETE/api/claims/{id}")
	ResponseEntity<Claim> deleteClaimbyIdHandler(@PathVariable("id") Long id) throws ClaimNotFoud {
		Claim c = claimservices.deletbyid(id);
		return new ResponseEntity<Claim>(c, HttpStatus.OK);
	}

	//http://localhost:8181/InsurenceManagementPlatform/PUT/api/claims/update
	@PutMapping("/PUT/api/claims/update")
	ResponseEntity<Claim> updateClaimByIdHandler(@RequestBody Claim c) throws ClaimNotFoud {
		Claim cl = claimservices.updateClaim(c);
		return new ResponseEntity<Claim>(cl, HttpStatus.OK);
	}
	
}
