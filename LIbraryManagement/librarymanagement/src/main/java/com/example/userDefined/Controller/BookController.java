package com.example.userDefined.Controller;

import com.example.userDefined.Model.Book;
import com.example.userDefined.Service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    Logger log=LoggerFactory.getLogger(BookController.class);
    @GetMapping("/inventory")

    public String getInventory(){
        log.info("Inventory is accessed");
        return bookService.inventory();
    }

    @GetMapping("")
    public List<Book> getBooks(){
        log.info("All Books has been accessed");
        return bookService.getBooks();
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable String id){
        log.info("The Book with id " + id + " has been accessed");
        return bookService.getBook(id);
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book){
        log.info("The Book has been added to the database :"+book);
        return bookService.addBook(book);
    }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable String id,@RequestBody Book book){
        log.info("The Book with id "+id+" has been accessed to update to : "+book);
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        log.info("The Book with id " + id + " has been accessed to be deleted from the database");
        return bookService.deleteBook(id);
    }
}
