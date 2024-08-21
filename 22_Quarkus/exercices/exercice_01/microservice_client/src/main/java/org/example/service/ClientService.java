package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.example.entity.Client;
import org.example.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    @Transactional
    public Client createClient(String name, String email, String phone) {
        Client client = Client.builder().name(name).email(email).phone(phone).build();
        clientRepository.persist(client);
        return client;
    }

    public Optional<Client> getClientById(long id) {
        return clientRepository.findByIdOptional(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.listAll();
    }

    @Transactional
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public Client updateClientById(long id, Client client) {
        Client updatedClient = clientRepository.findByIdOptional(id).orElseThrow();
        updatedClient.setName(client.getName());
        updatedClient.setEmail(client.getEmail());
        updatedClient.setPhone(client.getPhone());
        clientRepository.persist(updatedClient);
        return updatedClient;
    }
}
