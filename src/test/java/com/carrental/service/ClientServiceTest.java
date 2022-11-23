package com.carrental.service;

import com.carrental.domain.Client;
import com.carrental.domain.enums.TypeOfIdentificationNumber;
import com.carrental.exceptions.ClientNotFoundException;
import com.carrental.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Test
    void getAllClientsTest() {
        //Given
        List<Client> clientList = new ArrayList<>();

        Client client1 = new Client(1L, "Mariusz Kowalski", "1 Maja", "1",
                "43-202", "Zabrze", "Polska", null, TypeOfIdentificationNumber.NIP,
                "90010123948", "54500099", "mariusz.kowalski@onet.pl", null,
                null);

        Client client2 = new Client(2L, "Tomasz Nowak", "Konstytucji", "19",
                "43-200", "Opole", "Polska", "Opole", TypeOfIdentificationNumber.NIP,
                "7705043245", "5006788890", "tomasz.nowak@onet.pl", null,
                null);

        clientList.add(client1);
        clientList.add(client2);
        when(clientRepository.findAll()).thenReturn(clientList);
        //When
        List<Client> resultList = clientService.getAllClients();
        //Then
        assertEquals(2, resultList.size());
    }

    @Test
    void getClientTest() throws ClientNotFoundException {
        //Given

        Client client1 = new Client(1L, "Mariusz Kowalski", "1 Maja", "1",
                "43-202", "Zabrze", "Polska", null, TypeOfIdentificationNumber.NIP,
                "90010123948", "54500099", "mariusz.kowalski@onet.pl", null,
                null);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client1));
        //When
        Client result = clientService.findClientById(1L);
        //Then
        assertEquals(client1, result);
    }

    @Test
    void saveClientTest() throws ClientNotFoundException {
        //Given

        Client client1 = new Client(1L, "Mariusz Kowalski", "1 Maja", "1",
                "43-202", "Zabrze", "Polska", null, TypeOfIdentificationNumber.NIP,
                "90010123948", "54500099", "mariusz.kowalski@onet.pl", null,
                null);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client1));
        //When
        Client updateClient = clientService.findClientById(1L);
        updateClient.setName("Mateusz Kowalski");
        clientService.saveClient(updateClient);
        //Then
        assertEquals("Mateusz Kowalski", updateClient.getName());
    }
}
