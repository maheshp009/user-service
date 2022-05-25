package com.example.userservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")

public class UserDto {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String address;
    private String dateOfBirth;
    private String gender;

    public UserDto(String firstName ,
                String lastName ,
                String middleName ,
                String phoneNumber ,
                String email ,
                String address ,
                String dateOfBirth ,
                String gender ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.dateOfBirth = String.valueOf(dateOfBirth);
        this.gender = gender;


    }
}

