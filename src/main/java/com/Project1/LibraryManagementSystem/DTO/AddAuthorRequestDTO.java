package com.Project1.LibraryManagementSystem.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddAuthorRequestDTO {
    private String name;
    private int age;
    private String mobileNo;
    private String email;
}
