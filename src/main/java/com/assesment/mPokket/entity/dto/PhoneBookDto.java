package com.assesment.mPokket.entity.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PhoneBookDto {
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^((\\+91)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phoneNumber;
}
