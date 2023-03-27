package com.Project1.LibraryManagementSystem.DTO;


import com.Project1.LibraryManagementSystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueBookResponseDto {

    private String transanctionId;

    private String bookName;

    private TransactionStatus transactionStatus;
}
