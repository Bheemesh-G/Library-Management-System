package com.Project1.LibraryManagementSystem.Controller;


import com.Project1.LibraryManagementSystem.DTO.AddBookRequestDTO;
import com.Project1.LibraryManagementSystem.DTO.AddBookResponseDTO;
import com.Project1.LibraryManagementSystem.Entity.Book;
import com.Project1.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public AddBookResponseDTO addBook(@RequestBody AddBookRequestDTO addBookRequestDTO)
    {
    return bookService.addBook(addBookRequestDTO);
    }
}
