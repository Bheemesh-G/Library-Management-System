package com.Project1.LibraryManagementSystem.Entity;

import com.Project1.LibraryManagementSystem.Enum.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int price;

    private boolean issued;


    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;


    @ManyToOne
    @JoinColumn
    LibraryCard card;

    @OneToMany(mappedBy="book",cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();


}
