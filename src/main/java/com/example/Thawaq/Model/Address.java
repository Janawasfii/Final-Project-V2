package com.example.Thawaq.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "VARCHAR(25) NOT NULL")
    private String city;
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String street;

    @OneToOne
    @JsonIgnore
    @MapsId
    private Branch branch;
}
