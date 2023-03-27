package com.Project1.LibraryManagementSystem.Service;


import com.Project1.LibraryManagementSystem.DTO.IssueBookRequestDTO;
import com.Project1.LibraryManagementSystem.DTO.IssueBookResponseDto;
import com.Project1.LibraryManagementSystem.Entity.Book;
import com.Project1.LibraryManagementSystem.Entity.LibraryCard;
import com.Project1.LibraryManagementSystem.Entity.Transaction;
import com.Project1.LibraryManagementSystem.Enum.CardStatus;
import com.Project1.LibraryManagementSystem.Enum.TransactionStatus;
import com.Project1.LibraryManagementSystem.Repository.BookRepository;
import com.Project1.LibraryManagementSystem.Repository.LibraryCardRepository;
import com.Project1.LibraryManagementSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.Transform;
import java.awt.datatransfer.Transferable;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryCardRepository libraryCardRepository;

    public IssueBookResponseDto issueBook(IssueBookRequestDTO issueBookRequestDTO) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        // 1 Step
        LibraryCard card;
        try{
            card = libraryCardRepository.findById(issueBookRequestDTO.getLibraryCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid card id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id");
        }

        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDTO.getBookId()).get();
        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Book Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id");
        }

        // both and card and book are valid
        transaction.setBook(book);
        transaction.setCard(card);

        if(card.getCardStatus()!= CardStatus.ACTIVE){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("Your card is not activated");
        }

        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Sorry! Book is already issued.");
            transactionRepository.save(transaction);
            throw new Exception("Sorry! Book is already issued.");
        }

        // I can issue the book
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction was succesfull");

        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);
        card.getTransaction().add(transaction);
        card.getBooks().add(book);

        libraryCardRepository.save(card);  // will save book and tranaction also

        // Prepare Response Dto
        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setTransanctionId(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setBookName(book.getTitle());


        return issueBookResponseDto;


    }

}
