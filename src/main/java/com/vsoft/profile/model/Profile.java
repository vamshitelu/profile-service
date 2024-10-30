package com.vsoft.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    private Long profileId;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private LocalTime timeOfBirth;
 //   private String caste;
 //   private String subCaste;
 //   private String religion;
    private List<Address> addresses;

}
