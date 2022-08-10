package com.example.userDefined.Service;

import com.example.userDefined.Exception.InvalidInput;
import com.example.userDefined.Exception.ObjectEmpty;
import com.example.userDefined.Exception.ObjectNotFoundException;
import com.example.userDefined.Model.Book;
import com.example.userDefined.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public String inventory()
    {
            List<Book> books = bookRepo.findAll();
            int available = 0;
            int issue = 0;
            for (Book m : books) {
                available = available + m.getAvailable();
                issue = issue + m.getIssued();
            }
            return books+"\n"+"Available Books: "+available+"\n"+"Issued Books: "+issue;
    }

    public List<Book> getBooks(){
        List<Book> books=bookRepo.findAll();
        if(!books.isEmpty()){
            return books;
        }
        else{
            throw new ObjectEmpty("The Book List is Empty.");
        }
    }

    public Book addBook(Book book){
        if(book.getTotal()<=0 || book.getAuthor()==null || book.getName()==null){
            throw new InvalidInput("The Input Book is Empty");
        }
        else{
            bookRepo.save(book);
            return book;
        }
    }

    public Book getBook(String id){
        Book book=bookRepo.getById(Integer.parseInt(id));
        if(book!=null){
            return book;
        }
        else{
            throw new ObjectNotFoundException("The Book with id : "+id+" is not present");
        }
    }

    public Book updateBook(String id,Book book){
        Book oldBook=bookRepo.getById(Integer.parseInt(id));
        if(oldBook!=null){
            if(book.getAvailable()<=0 || book.getAuthor()==null || book.getName()==null){
                throw new InvalidInput("The Input Book is Invalid");
            }
            else{
                oldBook.setAvailable(book.getAvailable());
                oldBook.setName(book.getName());
                oldBook.setAuthor(book.getAuthor());
                oldBook.setTotal(book.getTotal());
                oldBook.setIssued(book.getIssued());
                bookRepo.save(oldBook);
                return oldBook;
            }

        }
        else{
            throw new ObjectNotFoundException("The Book with id : "+id+ "is not found");
        }
    }

    public ResponseEntity<?> deleteBook(String id){
        Book book=bookRepo.getById(Integer.parseInt(id));
        if(book!=null){
            bookRepo.delete(book);
            return new ResponseEntity<>("The Book with id : "+id+ " is deleted successfully", HttpStatus.OK);
        }
        else{
            throw new ObjectNotFoundException("The Book with id :"+ id+ " is not found");
        }

    }
}
