package com.carrental.service;

import com.carrental.domain.Client;
import com.carrental.exceptions.ClientNotFoundException;
import com.carrental.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client findClientById(final Long clientId) throws ClientNotFoundException {
        return clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(final Client client) throws ClientNotFoundException {
        if (clientRepository.existsById(client.getClientId())) {
            clientRepository.save(client);
            return client;
        } else {
            throw new ClientNotFoundException();
        }
    }

    public void deleteClient(Long clientId) throws ClientNotFoundException {
        if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId);
        } else {
            throw new ClientNotFoundException();
        }
    }
}
