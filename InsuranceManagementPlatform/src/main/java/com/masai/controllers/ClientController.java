package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.ClientNotFound;
import com.masai.models.Client;
import com.masai.services.ClaintServices;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/InsurenceManagementPlatform")
public class ClientController {

	@Autowired
	private ClaintServices clientservice;
	
	
	//http://localhost:8181/InsurenceManagementPlatform/POST/api/clients
	@PostMapping("/POST/api/clients")
	ResponseEntity<Client>registerClientHandler(@Valid @RequestBody Client c){
		Client client= clientservice.registerCliant(c);
	return new ResponseEntity<Client>(client, HttpStatus.CREATED);
	}

	
	//http://localhost:8181/InsurenceManagementPlatform/GET/api/clients
	@GetMapping("/GET/api/clients")
	ResponseEntity<List<Client>> getListOfClientsHandler() throws ClientNotFound{
		List<Client> list=clientservice.getListOfClient();
		return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
	}
	
	
	//http://localhost:8181/InsurenceManagementPlatform/GET/api/clients/1
	@GetMapping("/GET/api/clients/{id}") 
	ResponseEntity<Client>getClientByidHandler(@PathVariable("id") Long id) throws ClientNotFound{
		Client client=clientservice.getClainmyid(id);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	
	
	//http://localhost:8181/InsurenceManagementPlatform/DELETE/api/clients/1
	@GetMapping("DELETE/api/clients/{id}")
	ResponseEntity<Client>deleteClientByIdHandler(@PathVariable("id") Long id) throws ClientNotFound{
		Client client=clientservice.deletbyid(id);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	
	
	//http://localhost:8181/InsurenceManagementPlatform/PUT/api/clients
	@PutMapping("/PUT/api/clients")
	ResponseEntity<Client>updateClientHandler(@RequestBody Client c) throws ClientNotFound{
		Client client= clientservice.updateClient(c);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
}
