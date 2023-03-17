package com.Project1.LibraryManagementSystem.Controller;

import com.Project1.LibraryManagementSystem.DTO.AddAuthorRequestDTO;
import com.Project1.LibraryManagementSystem.DTO.AddAuthorResponseDTO;
import com.Project1.LibraryManagementSystem.Entity.Author;
import com.Project1.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @PostMapping("/add-author")
    public AddAuthorResponseDTO addAuthor(@RequestBody AddAuthorRequestDTO addAuthorRequestDTO)
    {
      return authorService.addAuthor(addAuthorRequestDTO);
    }

    @GetMapping("/get-all-authors")
    public List<Author> getAllAuthors()
    {
        return authorService.getAllAuthors();
    }
}
