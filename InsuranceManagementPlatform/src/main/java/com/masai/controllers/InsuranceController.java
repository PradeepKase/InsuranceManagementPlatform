package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.InsurancePolicyNotFound;
import com.masai.models.InsurancePolicy;
import com.masai.services.InsurancePolicyServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/InsurenceManagementPlatform")
public class InsuranceController {

	@Autowired
	private InsurancePolicyServices insurancepolicyservice;
	
	
	//http://localhost:8181/InsurenceManagementPlatform/POST/Insurance
	@PostMapping("/POST/Insurance")
	ResponseEntity<InsurancePolicy>registerInsuranceHandler(@Valid @RequestBody InsurancePolicy insu){
		InsurancePolicy insurancepolicy=insurancepolicyservice.saveInsurencePolicy(insu);
		return new ResponseEntity<InsurancePolicy>(insurancepolicy, HttpStatus.CREATED);
	}
	
	
	
	//http://localhost:8181/InsurenceManagementPlatform/GET/Insurance
	@GetMapping("/GET/Insurance")
	ResponseEntity<List<InsurancePolicy>> getListOfInsuranceHandler() throws InsurancePolicyNotFound{
		List<InsurancePolicy> list=insurancepolicyservice.getListOfPolcies();
		return new ResponseEntity<List<InsurancePolicy>>(list, HttpStatus.OK);
	}
	
	
	//http://localhost:8181/InsurenceManagementPlatform/GET/Insurance/1
	@GetMapping("/GET/Insurance/{id}")
	ResponseEntity<InsurancePolicy>getInsuranceByIdhandler(@PathVariable("id") Long id) throws InsurancePolicyNotFound{
		InsurancePolicy insurancepolicy=insurancepolicyservice.getInsurancePolicyByid(id);
		return new ResponseEntity<InsurancePolicy>(insurancepolicy, HttpStatus.OK);
	}
	
	
	
	//http://localhost:8181/InsurenceManagementPlatform/DELETE/deleteInsurance/1
	@GetMapping("/DELETE/deleteInsurance/{id}")
	ResponseEntity<InsurancePolicy>deleteInsuranceByIdhandler(@PathVariable("id") Long id) throws InsurancePolicyNotFound{
		InsurancePolicy insurancepolicy=insurancepolicyservice.deleteById(id);
		return new ResponseEntity<InsurancePolicy>(insurancepolicy, HttpStatus.OK);
	}
	
	
	
	//http://localhost:8181/InsurenceManagementPlatform/UPDATE/Insurance/policy
	@GetMapping("/UPDATE/Insurance/policy")
	ResponseEntity<InsurancePolicy>updateInsuranceByIdhandler(@RequestBody InsurancePolicy insu) throws InsurancePolicyNotFound{
		InsurancePolicy insurancepolicy=insurancepolicyservice.updateinsurance(insu);
		return new ResponseEntity<InsurancePolicy>(insurancepolicy, HttpStatus.OK);
	}
	
	
}
