package com.carrental.mapper;

import com.carrental.domain.Client;
import com.carrental.domain.enums.TypeOfIdentificationNumber;
import com.carrental.domain.dto.ClientDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClientMapperTestSuite {

    @Test
    void mapToClientTest() {
        //Given
        ClientMapper clientMapper = new ClientMapper();
        ClientDto clientDto = new ClientDto(1L, "Mariusz Kowalski", "1 Maja", 1L, "43-202", "Zabrze", "Polska", null, TypeOfIdentificationNumber.NIP, 90010123948L, 54500099L, "mariusz.kowalski@onet.pl", Collections.emptyList(), Collections.emptyList());
        //When
        Client client = clientMapper.mapToClient(clientDto);
        //Then
        assertNotNull(client.getClientId());
        assertEquals("Mariusz Kowalski", client.getName());
    }

    @Test
    void mapToClientDtoTest() {
        //Given
        ClientMapper clientMapper = new ClientMapper();
        Client client = new Client(2L, "Tomasz Nowak", "Konstytucji", 19L, "43-200", "Opole", "Polska", "Opole", TypeOfIdentificationNumber.NIP, 7705043245L, 5006788890L, "tomasz.nowak@onet.pl", Collections.emptyList(), Collections.emptyList());
        //When
        ClientDto clientDto = clientMapper.mapToClientDto(client);
        //Then
        assertNotNull(clientDto.getClientId());
        assertEquals("Konstytucji", clientDto.getStreet());
    }

    @Test
    void mapToClientDtoListTest() {
        //Given
        ClientMapper clientMapper = new ClientMapper();
        List<Client> clientList = new ArrayList<>();
        Client client1 = new Client(1L, "Mariusz Kowalski", "1 Maja", 1L, "43-202", "Zabrze", "Polska", null, TypeOfIdentificationNumber.NIP, 90010123948L, 54500099L, "mariusz.kowalski@onet.pl", Collections.emptyList(), Collections.emptyList());
        Client client2 = new Client(2L, "Tomasz Nowak", "Konstytucji", 19L, "43-200", "Opole", "Polska", "Opole", TypeOfIdentificationNumber.NIP, 7705043245L, 5006788890L, "tomasz.nowak@onet.pl", Collections.emptyList(), Collections.emptyList());
        clientList.add(client1);
        clientList.add(client2);
        //When
        List<ClientDto> clientDtoList = clientMapper.mapToClientDtoList(clientList);
        //Then
        assertNotNull(clientDtoList.get(0).getClientId());
        assertEquals(2, clientDtoList.size());
        assertEquals("1 Maja", clientDtoList.get(0).getStreet());
        assertEquals("Opole", clientDtoList.get(1).getCity());
    }
}
