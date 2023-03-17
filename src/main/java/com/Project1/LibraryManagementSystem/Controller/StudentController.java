package com.Project1.LibraryManagementSystem.Controller;


import com.Project1.LibraryManagementSystem.DTO.StudentGetByIdResponse;
import com.Project1.LibraryManagementSystem.DTO.StudentRequestDTO;
import com.Project1.LibraryManagementSystem.Entity.Student;
import com.Project1.LibraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO)
    {
       return studentService.addStudent(studentRequestDTO);
    }



    @GetMapping("/get-all-students")
    public List<String> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/get-student/{id}")
    public StudentGetByIdResponse getStudent(@PathVariable int id)
    {
        return studentService.getStudent(id);
    }

    @GetMapping("/get-student-by-email")
    public String findByEmail(@RequestParam String email)
    {
        return studentService.findByEmail(email);
    }



    @GetMapping("/get-student-by-age/{age}")
    public List<String> findByAge(@PathVariable int age)
    {
        return studentService.findByAge(age);
    }
}
