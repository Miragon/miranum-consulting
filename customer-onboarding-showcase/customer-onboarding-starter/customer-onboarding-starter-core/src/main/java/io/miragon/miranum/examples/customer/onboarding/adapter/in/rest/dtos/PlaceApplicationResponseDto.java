package io.miragon.miranum.examples.customer.onboarding.adapter.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlaceApplicationResponseDto {

    private String name;
    private String email;
    private String address;
    private String income;
    private String employment;
}