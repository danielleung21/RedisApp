package com.daniel.topaz.rba.controllers;

import com.daniel.topaz.rba.dm.Student;
import com.daniel.topaz.rba.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository repository;

    @PostMapping
    public String createStudent() {
        Student student = new Student("Eng2015001","John Doe", Student.Gender.MALE,1);

        repository.save(student);
        return "Succeed";
    }

    @GetMapping("/{studentId}")
    public String findStudentById(@PathVariable String studentId) {
        Student student = repository.findById(studentId).get();

        logger.info("{}",student);
        return "Succeed";
    }
}
