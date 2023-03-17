package com.Project1.LibraryManagementSystem.Entity;


import com.Project1.LibraryManagementSystem.Enum.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;


    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(unique = true)
    private String email;

    //when we add student then we need to add card automatically
    @OneToOne(mappedBy="student",cascade = CascadeType.ALL)
    LibraryCard libraryCard;

}
