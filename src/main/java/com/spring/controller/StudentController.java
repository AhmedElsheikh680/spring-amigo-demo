package com.spring.controller;

import com.spring.model.Student;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> students(){
        return studentService.students();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping("/student")
    public Student add(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
//        Student studentExist = studentService.findById(id);
//        studentService.deleteStudent(studentExist.getId());
//        return ResponseEntity.ok(null);
        studentService.deleteStudent(id);
        return ResponseEntity.ok(null);
    }

}
