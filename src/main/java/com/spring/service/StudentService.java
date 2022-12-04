package com.spring.service;

import com.spring.exception.DuplicateRecordException;
import com.spring.exception.RecordNotFoundException;
import com.spring.model.Student;
import com.spring.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

//@Component
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public List<Student> students() {
        return studentRepo.findAll();
//        return List.of(
//                new Student(
//                        1L, "Ahmed", "ahmed@ahmed.com",
//                        LocalDate.of(2022, Month.JANUARY, 15), 25));
    }
    public Student findById(Long id){
        Optional<Student> student =  studentRepo.findById(id);
        if (student.isPresent()){
            return student.get();
        } else{
            throw new RecordNotFoundException("This Record With ID: "+ id + " Not Found!!");
        }
    }

    public Student addStudent(Student student) {
        if (!student.getEmail().isEmpty() && student.getEmail() != null) {
            Optional<Student> studentByEmail = studentRepo.findStudentByEmail(student.getEmail());
            if (studentByEmail.isPresent()) {
                throw new DuplicateRecordException("This Email Already Exist!!!");
        }}
        return  studentRepo.save(student);
    }

    public void deleteStudent(Long id){
       boolean exists =  studentRepo.existsById(id);
       if (!exists){
           throw new RecordNotFoundException("This ID "+ id+ " Not Found!!");
       }
        studentRepo.deleteById(id);
    }
}
