package com.Project1.LibraryManagementSystem.DTO;


import com.Project1.LibraryManagementSystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDTO {
    private String name;
    private int age;
    private Department department;
    private String email;
}
