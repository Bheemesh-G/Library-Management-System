package com.Project1.LibraryManagementSystem.DTO;

import com.Project1.LibraryManagementSystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddBookRequestDTO {

private String title;
private int price;
private Genre genre;

private int authorId;
}
