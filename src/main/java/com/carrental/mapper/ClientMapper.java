package com.carrental.mapper;

import com.carrental.domain.Client;
import com.carrental.domain.dto.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .identityCardNumber(clientDto.getIdentityCardNumber())
                .drivingLicenseNumber(clientDto.getDrivingLicenseNumber())
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
                client.getIdentityCardNumber(),
                client.getDrivingLicenseNumber(),
                client.getPhoneNumber(),
                client.getEmail(),
                client.getDrivers(),
                client.getCarRents()
        );
    }

    public List<ClientDto> mapToClientDtoList(final List<Client> clients) {
        return clients.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }
}
