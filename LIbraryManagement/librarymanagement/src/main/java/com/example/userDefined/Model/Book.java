package com.example.userDefined.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

@Entity
@Table(name="Books")
@JsonPropertyOrder({"book_id","book_name","book_author","total"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonProperty("book_id")
    private int id;
    @Column(name="name")
    @JsonProperty("book_name")
    private String name;
    @Column(name="author")
    @JsonProperty("book_author")
    private String author;
    @Column(name="total")
    private int total;
    @Column(name="available")
    private int available;
    @Column(name="issued")
    private int issued;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", total=" + total +
                ", available=" + available +
                ", issued=" + issued +
                '}';
    }
}
