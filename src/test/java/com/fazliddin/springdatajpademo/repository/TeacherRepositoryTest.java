package com.fazliddin.springdatajpademo.repository;

import com.fazliddin.springdatajpademo.entity.Course;
import com.fazliddin.springdatajpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseSWE = Course.builder()
                .title("SWE")
                .credit(4)
                .build();
        Course courseMPP = Course.builder()
                .title("MPP")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Obina")
                .lastName("Kalu")
                //.courses(List.of(courseSWE, courseMPP))
                .build();
        teacherRepository.save(teacher);
    }
}