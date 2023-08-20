package com.example.hw21.DTO;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;
    @Size(min = 3,message = "area name is too short")
    private String area;
    @Size(min = 3,message = "street name is too short")
    private String street;
    @Positive
    private Integer buildingNumber;
}
