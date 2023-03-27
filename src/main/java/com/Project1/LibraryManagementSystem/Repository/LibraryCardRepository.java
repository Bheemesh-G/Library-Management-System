package com.Project1.LibraryManagementSystem.Repository;

import com.Project1.LibraryManagementSystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard,Integer> {
}
