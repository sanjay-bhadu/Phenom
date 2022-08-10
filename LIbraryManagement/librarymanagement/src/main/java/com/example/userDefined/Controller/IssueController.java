package com.example.userDefined.Controller;

import com.example.userDefined.Model.Book;
import com.example.userDefined.Model.Issue;
import com.example.userDefined.Model.Student;
import com.example.userDefined.Service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @GetMapping("")
    public List<Issue> getAllIssue()
    {
        return issueService.getIssues();
    }

    @GetMapping("{id}")
    public Issue getIssue(@PathVariable String id)
    {
        return issueService.getIssue(id);
    }

    @PostMapping("")
    public Object issueBook(@RequestParam String book_id,@RequestParam String student_id)
    {
        return issueService.addIssue(book_id,student_id);
    }

    @DeleteMapping("/return/{book_id}")
    public ResponseEntity<?> returnBook(@PathVariable String book_id,@RequestParam String student_id)
    {
      return issueService.returnBook(book_id,student_id);
    }

    @GetMapping("/issueStudent/{id}")
    public List<Book> getBookByStudent(@PathVariable String id)
    {
      return issueService.getBooksByStudent(id);
    }

    @GetMapping("/issueBook/{id}")
    public List<Student> getStudentByBook(@PathVariable String id)
    {
       return issueService.getStudentByBook(id);
    }

}