package com.example.userDefined.Controller;

import com.example.userDefined.Model.Student;
import com.example.userDefined.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    Logger log= LoggerFactory.getLogger(StudentController.class);

    @GetMapping("")
    public List<Student> getStudent()
    {
        log.info("The All list of Student has been Accessed");
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    @RolesAllowed("Admin")
    public Student getStudentById(@PathVariable String id)
    {
        log.info("The Student with ID "+id+" was accessed");
       return studentService.getStudent(id);
    }

    @PostMapping("")
    public Student addStudent(@RequestBody Student student)
    {
        log.info("The Student has been added to the database :"+student);
        return studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable String id,@RequestBody Student student)
    {
        log.info("The Student with id "+id+ " has been accessed to to be updated to :"+student);
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id)
    {
        log.info("The Student with id "+id+" has been accessed to delete");
        return studentService.deleteStudent(id);
    }
}
