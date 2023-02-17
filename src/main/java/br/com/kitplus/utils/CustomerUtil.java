package br.com.kitplus.utils;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.common.PhoneRequest;
import com.mercadopago.client.customer.CustomerAddressRequest;
import com.mercadopago.client.customer.CustomerRequest;

public class CustomerUtil {

    public static CustomerRequest createCustomerRequest(br.com.kitplus.models.Clients.CustomerRequest customer, String type) {
        return CustomerRequest.builder()
                .email( type == "create" ? customer.getEmail(): null)
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(PhoneRequest.builder()
                        .areaCode(customer.getPhone().getAreaCode())
                        .number(customer.getPhone().getNumber()).build())
                .identification(
                        IdentificationRequest.builder()
                                .type(customer.getIdentification().getType())
                                .number(customer.getIdentification().getNumber()).build())
                .defaultAddress("Home")
                .address(
                        CustomerAddressRequest.builder()
                                .id(customer.getAddress().getId())
                                .zipCode(customer.getAddress().getZipCode())
                                .streetName(customer.getAddress().getStreetName())
                                .streetNumber(customer.getAddress().getStreetNumber())
                                .build())
                .dateRegistred(OffsetDateTime.of(2000, 1, 18, 0, 0, 0, 0, ZoneOffset.UTC))
                .description(customer.getDescription())
                .defaultCard(customer.getDefaultCard())
                .build();
    }
}
