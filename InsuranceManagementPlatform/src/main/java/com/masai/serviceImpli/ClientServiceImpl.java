package com.masai.serviceImpli;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.Repo.ClientRepo;
import com.masai.exceptions.ClientNotFound;
import com.masai.models.Client;
import com.masai.services.ClaintServices;

@Service
public class ClientServiceImpl implements ClaintServices {

	@Autowired
	private ClientRepo clientrepo;

	@Override
	public Client registerCliant(Client c) {
		// TODO Auto-generated method stub
		Client client = clientrepo.save(c);
		return client;
	}

	@Override
	public List<Client> getListOfClient() throws ClientNotFound {
		// TODO Auto-generated method stub
		List<Client> list = clientrepo.findAll();
		if (list.size() == 0) {
			throw new ClientNotFound("there are no clients");
		} else {
			return list;
		}
	}

	@Override
	public Client getClainmyid(Long id) throws ClientNotFound {
		// TODO Auto-generated method stub
		return clientrepo.findById(id).orElseThrow(() -> new ClientNotFound("client not found with this " + id));
	}

	@Override
	public Client updateClient(Client c) throws ClientNotFound {
		// TODO Auto-generated method stub
		Optional<Client> opt = clientrepo.findById(c.getId());
		if (opt.isPresent()) {
			Client client = clientrepo.save(c);
			return client;
		} else {
			throw new ClientNotFound("claint not updated");
		}
	}

	@Override
	public Client deletbyid(Long id) throws ClientNotFound {
		// TODO Auto-generated method stub
		Optional<Client> opt = clientrepo.findById(id);
		if (opt.isPresent()) {
			Client client = opt.get();
			clientrepo.delete(client);
			return client;
		} else {
			throw new ClientNotFound("clinet not found with this id" + id);
		}
	}

}
