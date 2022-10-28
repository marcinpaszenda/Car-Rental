package com.carrental.controller;

import com.carrental.domain.Client;
import com.carrental.domain.dto.ClientDto;
import com.carrental.exceptions.ClientNotFoundException;
import com.carrental.mapper.ClientMapper;
import com.carrental.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clientMapper.mapToClientDtoList(clients));
    }

    @GetMapping(value = "{clientId}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long clientId) throws ClientNotFoundException {
        return ResponseEntity.ok(clientMapper.mapToClientDto(clientService.findClientById(clientId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> addClient(@RequestBody ClientDto clientDto) {
        Client client = clientMapper.mapToClient(clientDto);
        clientService.saveClient(client);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(client);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClient(@RequestBody ClientDto clientDto) throws ClientNotFoundException {
        Client client = clientMapper.mapToClient(clientDto);
        Client updatedClient = clientService.updateClient(client);
        clientMapper.mapToClientDto(updatedClient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) throws ClientNotFoundException {
        clientService.deleteClient(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
