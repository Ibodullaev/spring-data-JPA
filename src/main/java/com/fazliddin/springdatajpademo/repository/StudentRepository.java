package com.fazliddin.springdatajpademo.repository;

import com.fazliddin.springdatajpademo.entity.Guardian;
import com.fazliddin.springdatajpademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
     List<Student> findByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String name);
     List<Student> findByLastNameNotNull();
     List<Student> findByGuardianName(String name);

     @Query("select s from Student s where s.email = ?1") //JPQL queries
     Student getStudentByEmailAddress(String email);

     @Query(
             value = "SELECT * FROM student as s WHERE s.email_address = ?1", //Native query
             nativeQuery = true
     )
     Student getStudentByEmailAddressNative(String email);

     @Query(
             value = "SELECT * FROM student as s WHERE s.email_address = :email", //Native query with named param
             nativeQuery = true
     )
     Student getStudentByEmailAddressNativeNamedParam(@Param("email") String email);

     @Modifying
     @Transactional
     @Query(value = "UPDATE student SET firstName = ?1 WHERE email_address = ?2", nativeQuery = true)
     int updateStudentNameByEmail(String firstName, String email);
}
