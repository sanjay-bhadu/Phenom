package com.example.userDefined.Service;

import com.example.userDefined.Exception.InvalidInput;
import com.example.userDefined.Exception.NotAvailable;
import com.example.userDefined.Exception.ObjectEmpty;
import com.example.userDefined.Exception.ObjectNotFoundException;
import com.example.userDefined.Model.Book;
import com.example.userDefined.Model.Issue;
import com.example.userDefined.Model.Student;
import com.example.userDefined.Repo.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IssueService {
    @Autowired
    private IssueRepo issueRepo;
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;

    public List<Issue> getIssues(){

        List<Issue> issueList=issueRepo.findAll();
        if(issueList.isEmpty())
            throw new ObjectNotFoundException("The List is empty");
        else
            return issueList;
    }

    public Issue getIssue(String id){
        Issue issue =issueRepo.getById(Integer.parseInt(id));
        if(issue==null)
            throw new ObjectEmpty("The Issue with id : "+id+ " is not found");
        else{
            return issue;
        }
    }

    public Issue addIssue(String book_id,String student_id){
        Book book = bookService.getBook(book_id);
        Student student =studentService.getStudent(student_id);
        if( book==null || student==null)
        {
            throw new InvalidInput("The Input you entered in not valid ... Kindly Check it");
        }
        else if(book.getAvailable()<1)
            throw new NotAvailable("There are not enough copies of this book");

        else {
            Issue issue = new Issue();
            issue.setStudent(student);
            book.setIssued(book.getIssued()+1);
            book.setAvailable(book.getAvailable()-1);
            book=bookService.updateBook(book_id,book);
            issue.setBook(book);
            issueRepo.save(issue);
            return issue;
        }
    }

    public List<Book> getBooksByStudent(String student_id){
        List<Book> books=issueRepo.findByStudentId(Integer.parseInt(student_id));
        if(books.isEmpty())
            throw new ObjectEmpty("There are no books issued to this student");
        else
            return books;
    }

    public List<Student> getStudentByBook(String book_id)
    {
        List<Student> students=issueRepo.findByBookId(Integer.parseInt(book_id));
        if(students.isEmpty())
            throw new ObjectEmpty("There are no students taken this book");
        else
            return students;
    }

    public ResponseEntity<?> returnBook(String book_id,String student_id)
    {
        List<Issue> issue=issueRepo.findIssueByBookId(Integer.parseInt(book_id));
        if(!issue.isEmpty())
        {
            Issue temp=null;
            for(Issue i: issue)
            {
                if(i.getStudent().getId()==Integer.parseInt(student_id))
                {
                    temp=i;
                    break;
                }
            }
            if(temp!=null)
            {
                Book book=temp.getBook();
                book.setAvailable(book.getAvailable()+1);
                book.setIssued(book.getIssued()-1);
                bookService.updateBook(book_id,book);
                issueRepo.delete(temp);
                return new ResponseEntity<>("The Book is returned successfully", HttpStatus.ACCEPTED);
            }
            else {
                return new ResponseEntity<>("The Book not found ",HttpStatus.NOT_FOUND);
            }
        }
        else{
            return new ResponseEntity<>("The Issue List is Empty",HttpStatus.BAD_REQUEST);
        }
    }
}
