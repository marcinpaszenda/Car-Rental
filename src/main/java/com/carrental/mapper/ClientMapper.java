package com.carrental.mapper;

import com.carrental.domain.Client;
import com.carrental.domain.Driver;
import com.carrental.domain.dto.ClientDto;
import com.carrental.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientMapper {

    public Client mapToClient(final ClientDto clientDto) {
        return Client.builder()
                .clientId(clientDto.getClientId())
                .name(clientDto.getName())
                .street(clientDto.getStreet())
                .streetNumber(clientDto.getStreetNumber())
                .postalCode(clientDto.getPostalCode())
                .city(clientDto.getCity())
                .country(clientDto.getCountry())
                .placeOfBirth(clientDto.getPlaceOfBirth())
                .typeOfIdentificationNumber(clientDto.getTypeOfIdentificationNumber())
                .identificationNumber(clientDto.getIdentificationNumber())
                .phoneNumber(clientDto.getPhoneNumber())
                .email(clientDto.getEmail())
                .drivers(clientDto.getDrivers())
                .carRents(clientDto.getCarRents())
                .build();
    }

    public ClientDto mapToClientDto(final Client client) {
        return new ClientDto(
                client.getClientId(),
                client.getName(),
                client.getStreet(),
                client.getStreetNumber(),
                client.getPostalCode(),
                client.getCity(),
                client.getCountry(),
                client.getPlaceOfBirth(),
                client.getTypeOfIdentificationNumber(),
                client.getIdentificationNumber(),
                client.getPhoneNumber(),
                client.getEmail(),
                new ArrayList<>(client.getDrivers()),
                new ArrayList<>(client.getCarRents())
        );
    }

    public List<ClientDto> mapToClientDtoList(final List<Client> clients) {
        return clients.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }
}