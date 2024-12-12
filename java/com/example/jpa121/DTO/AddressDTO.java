package com.example.jpa121.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacherId;

    @NotEmpty(message = "Area cannot be null")
    private String area;

    @NotEmpty(message = "street cannot be empty")
    private String street;

    @NotNull(message = " Building Number cannot be null")
    private Integer buildingNumber;



}
