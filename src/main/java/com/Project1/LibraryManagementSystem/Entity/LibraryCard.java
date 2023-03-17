package com.Project1.LibraryManagementSystem.Entity;

import com.Project1.LibraryManagementSystem.Enum.CardStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LibraryCard {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;


    @CreationTimestamp
    private Date creationDate;


    @UpdateTimestamp
    private Date updateDate;

    //now making connection with parent table

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Student student;

    @OneToMany(mappedBy = "card",cascade=CascadeType.ALL)
    List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade=CascadeType.ALL)
    List<Transaction> transaction = new ArrayList<>();


}
