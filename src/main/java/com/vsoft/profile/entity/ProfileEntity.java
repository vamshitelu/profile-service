package com.vsoft.profile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
    private String firstName;
    private String lastName;
    private String gender;
 //   @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
 //   @Temporal(TemporalType.TIME)
    private LocalTime timeOfBirth;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AddressEntity> addresses = new ArrayList<>();


}
