package com.Project1.LibraryManagementSystem.Service;


import com.Project1.LibraryManagementSystem.DTO.AddBookRequestDTO;
import com.Project1.LibraryManagementSystem.DTO.AddBookResponseDTO;
import com.Project1.LibraryManagementSystem.Entity.Author;
import com.Project1.LibraryManagementSystem.Entity.Book;
import com.Project1.LibraryManagementSystem.Repository.AuthorRepository;
import com.Project1.LibraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public AddBookResponseDTO addBook(AddBookRequestDTO addBookRequestDTO)
    {

        Author author = authorRepository.findById(addBookRequestDTO.getAuthorId()).get();

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(addBookRequestDTO.getTitle());
        book.setPrice(addBookRequestDTO.getPrice());
        book.setGenre(addBookRequestDTO.getGenre());

        book.setIssued(false);

        author.getBooks().add(book);

        authorRepository.save(author);

        AddBookResponseDTO addBookResponseDTO = new AddBookResponseDTO();
        addBookResponseDTO.setPrice(book.getPrice());
        addBookResponseDTO.setTitle(book.getTitle());
        addBookResponseDTO.setMessage("Book added Successfully");

      /*  List<Book> bookswritten = author.getBooks();

        for(Book i:bookswritten)
        {
            System.out.print(i.getTitle()+" ");
        }  */


        return addBookResponseDTO;

    }
}
