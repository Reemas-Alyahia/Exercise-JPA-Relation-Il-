package com.example.jpa121.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;


    @NotEmpty(message = "Area cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @NotEmpty(message = "street cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;

    @NotNull(message = " Building Number cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
