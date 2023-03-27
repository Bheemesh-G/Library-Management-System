package com.Project1.LibraryManagementSystem.Controller;


import com.Project1.LibraryManagementSystem.DTO.IssueBookRequestDTO;
import com.Project1.LibraryManagementSystem.DTO.IssueBookResponseDto;
import com.Project1.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;


    @PostMapping("/issue")
    public ResponseEntity issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO) throws Exception{

        IssueBookResponseDto issueBookResponseDto;
        try{
            issueBookResponseDto = transactionService.issueBook(issueBookRequestDTO);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }



        return new ResponseEntity(issueBookResponseDto,HttpStatus.ACCEPTED);




    }
}
