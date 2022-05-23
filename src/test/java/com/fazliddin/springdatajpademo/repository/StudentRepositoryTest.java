package com.fazliddin.springdatajpademo.repository;

import com.fazliddin.springdatajpademo.entity.Guardian;
import com.fazliddin.springdatajpademo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .email("fazikacme@gmail.com")
                .firstName("Fazlidin")
                .lastName("Ibodullaev")
                //.guardianName("Nazarali")
                //.guardianEmail("nazarali@gmail.com")
                //.guardianMobile("+998977720743")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Nazarali")
                .email("nazarali@gmail.com")
                .mobile("+998977720743")
                .build();
        Student student = Student.builder()
                .email("ifazliddin@gmail.com")
                .firstName("Fazlidin")
                .lastName("Ibodullaev")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void findByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Fazliddin");
        System.out.println(students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Faz");
        System.out.println(students);
    }

    @Test
    public void findByLastNameNotNull(){
        List<Student> students = studentRepository.findByLastNameNotNull();
        System.out.println(students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nazarali");
        System.out.println(students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("fazikacme@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("fazikacme@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("fazikacme@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmail(){
        studentRepository.updateStudentNameByEmail("Fazliddin", "fazikacme@gmail.com");
    }
}