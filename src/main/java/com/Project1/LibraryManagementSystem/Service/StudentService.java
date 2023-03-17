package com.Project1.LibraryManagementSystem.Service;


import com.Project1.LibraryManagementSystem.DTO.StudentGetByIdResponse;
import com.Project1.LibraryManagementSystem.DTO.StudentRequestDTO;
import com.Project1.LibraryManagementSystem.Entity.LibraryCard;
import com.Project1.LibraryManagementSystem.Entity.Student;
import com.Project1.LibraryManagementSystem.Enum.CardStatus;
import com.Project1.LibraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //we need to set default values of LibraryCard
    public String addStudent(StudentRequestDTO studentRequestDTO)
    {
      Student student = new Student();
      student.setName(studentRequestDTO.getName());
      student.setAge(studentRequestDTO.getAge());
      student.setDepartment(studentRequestDTO.getDepartment());
      student.setEmail(studentRequestDTO.getEmail());

      LibraryCard card = new LibraryCard();
      card.setCardStatus(CardStatus.ACTIVE);
      card.setStudent(student);

      student.setLibraryCard(card);

      studentRepository.save(student);

     /* StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
      studentResponseDTO.setMessage("Student added Successfully");
      studentResponseDTO.setId(student.getId());
      studentResponseDTO.setName(student.getName());
      studentResponseDTO.setEmail(student.getEmail());  */

      return "Student added Successfully";

    }


    public List<String> getAllStudents()
    {
        List<Student> list = studentRepository.findAll();
        List<String> studentlist = new ArrayList<>();
        for(Student i:list)
        {
            studentlist.add(i.getName());
        }


        return studentlist;

    }

    public StudentGetByIdResponse getStudent(int id)
    {
        Student student = studentRepository.findById(id).get();
        StudentGetByIdResponse studentGetByIdResponse = new StudentGetByIdResponse();
        studentGetByIdResponse.setName(student.getName());
        studentGetByIdResponse.setId(student.getId());
        studentGetByIdResponse.setAge(student.getAge());
        studentGetByIdResponse.setEmail(student.getEmail());
        studentGetByIdResponse.setDepartment(student.getDepartment());

        return studentGetByIdResponse;
    }

    public String findByEmail(String email)
    {
        Student student =  studentRepository.findByEmail(email);

        return student.getName();
    }

    public List<String> findByAge(int age)
    {
        List<Student> list = studentRepository.findByAge(age);
        List<String> studentName = new ArrayList<>();
        for(Student i:list)
        {
            studentName.add(i.getName());
        }

        return studentName;
    }
}
