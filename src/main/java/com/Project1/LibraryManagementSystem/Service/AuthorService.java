package com.Project1.LibraryManagementSystem.Service;


import com.Project1.LibraryManagementSystem.DTO.AddAuthorRequestDTO;
import com.Project1.LibraryManagementSystem.DTO.AddAuthorResponseDTO;
import com.Project1.LibraryManagementSystem.Entity.Author;
import com.Project1.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public AddAuthorResponseDTO addAuthor(AddAuthorRequestDTO addAuthorRequestDTO)
    {

        Author author = new Author();
        author.setName(addAuthorRequestDTO.getName());
        author.setAge(addAuthorRequestDTO.getAge());
        author.setEmail(addAuthorRequestDTO.getEmail());
        author.setMobileNo(addAuthorRequestDTO.getMobileNo());

       Author author1 =  authorRepository.save(author);

        AddAuthorResponseDTO dto = new AddAuthorResponseDTO();
        dto.setId(author1.getId());
       dto.setName(author1.getName());


       return dto;


    }
    public List<Author> getAllAuthors()
    {
        return authorRepository.findAll();
    }
}
