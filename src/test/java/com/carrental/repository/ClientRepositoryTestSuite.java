package com.carrental.repository;

import com.carrental.domain.Client;
import com.carrental.domain.enums.TypeOfIdentificationNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClientRepositoryTestSuite {

    @Autowired
    private ClientRepository clientRepository;
    private Client client;

    @BeforeEach
    public void beforeTests() {
        client = Client.builder()
                .name("Mariusz Nowak")
                .street("Piłsudskiego")
                .streetNumber("55")
                .postalCode("43-100")
                .city("Katowice")
                .country("Polska")
                .placeOfBirth("Chorzów")
                .typeOfIdentificationNumber(TypeOfIdentificationNumber.PESEL)
                .identificationNumber("88121205453")
                .phoneNumber("501211223")
                .email("m.nowak@wp.pl")
                .build();
    }

    @Test
    public void saveClientTest() {
        //Given
        //When
        clientRepository.save(client);
        //Then
        assertTrue(clientRepository.existsById(client.getClientId()));
        assertEquals("Katowice", client.getCity());
        //CleanUp
        clientRepository.deleteById(client.getClientId());
    }

    @Test
    public void findClientByIdTest() {
        //Given
        clientRepository.save(client);
        String emailClient = "m.nowak@wp.pl";
        //When
        Client result = clientRepository.findById(client.getClientId()).get();
        //Then
        assertEquals("501211223", result.getPhoneNumber());
        assertEquals(emailClient, result.getEmail());
        //CleanUp
        clientRepository.deleteById(client.getClientId());
    }

    @Test
    public void deleteClientByIdTest() {
        //Given
        clientRepository.save(client);
        //When
        clientRepository.deleteById(client.getClientId());
        //Then
        assertEquals(Optional.empty(), clientRepository.findById(client.getClientId()));
    }
}
