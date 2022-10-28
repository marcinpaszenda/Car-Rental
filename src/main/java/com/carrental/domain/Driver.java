package com.carrental.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DRIVER")
public class Driver {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "DRIVER_ID")
    private Long driverId;

    @Column(name = "DRIVER_NAME")
    private String driverName;

    @Column(name = "IDENTITY_CARD_NUMBER")
    private String identityCardNumber;

    @Column(name = "DRIVING_LICENSE_NUMBER")
    private String drivingLicenseNumber;

    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;
}
