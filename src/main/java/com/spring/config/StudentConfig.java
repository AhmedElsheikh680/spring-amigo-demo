//package com.spring.config;
//
//
//import com.spring.model.Student;
//import com.spring.repo.StudentRepo;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Configuration
//public class StudentConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
//    return args -> {
//        Student ahmed= new Student(
//                 "Ahmed", "a@a.com", LocalDate.of(1996, 9, 2));
//        Student mohamed= new Student(
//                 "Mohamed", "m@m.com", LocalDate.of(1995, 8, 10));
//
//        studentRepo.saveAll(List.of(ahmed, mohamed));
//    };
//    }
//}
