package com.masai.services;

import java.util.List;
import com.masai.exceptions.ClientNotFound;
import com.masai.models.Client;

public interface ClaintServices {
	public Client registerCliant(Client c);

	public List<Client> getListOfClient() throws ClientNotFound;

	public Client getClainmyid(Long id) throws ClientNotFound;

	public Client updateClient(Client c) throws ClientNotFound;

	public Client deletbyid(Long id) throws ClientNotFound;
}
