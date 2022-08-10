package com.example.userDefined.Service;

import com.example.userDefined.Exception.InvalidInput;
import com.example.userDefined.Exception.ObjectEmpty;
import com.example.userDefined.Exception.ObjectNotFoundException;
import com.example.userDefined.Model.Student;
import com.example.userDefined.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    public StudentRepo studentRepo;

    public List<Student> getStudents(){
        List<Student> students=studentRepo.findAll();
        if(students.isEmpty())
            throw new ObjectEmpty("The Student List is Empty");
        else
            return students;
    }

    public Student getStudent(String id){
        Student student=studentRepo.getById(Integer.parseInt(id));
        if(student==null)
            throw new ObjectNotFoundException("Student with id: "+id + " is not found");
        else
            return student;
    }

    public Student updateStudent(String id,Student student){
        Student oldStudent=studentRepo.getById(Integer.parseInt(id));
        if(oldStudent==null)
            throw new ObjectNotFoundException("The Student with id: "+id+ " is not found");
        else{
            if(student.getEmail()==null || student.getName()==null)
                throw new InvalidInput("The Input Student is Invalid");
            else{
                oldStudent.setEmail(student.getEmail());
                oldStudent.setName(student.getName());
                studentRepo.save(oldStudent);
                return oldStudent;
            }
        }
    }

    public Student addStudent(Student student){
        if(student.getName()==null || student.getEmail()==null){
            throw new InvalidInput("The Input Student is Invalid");
        }
        else{
            studentRepo.save(student);
            return student;
        }
    }

    public ResponseEntity<?> deleteStudent(String id){
        Student student=studentRepo.getById(Integer.parseInt(id));
        if(student==null){
            throw new ObjectNotFoundException("The Student with id ; "+id +" is not found");
        }
        else{
            studentRepo.delete(student);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.ACCEPTED);
        }
    }
}
