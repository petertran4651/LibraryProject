/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salki
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private boolean available;
    private List<Integer> borrowerIds;

    public Book(int id, String title, String author, String publisher, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.available = true;
        this.borrowerIds = new ArrayList<Integer>();
    }
    
    public Book(String title, String author, int id, String publisher, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.available = true;
        this.borrowerIds = new ArrayList<Integer>();
    }
    
    //maybe include "copies" as well?
    
    public Book(int id) {
    this.id = id;
    this.title = "";
    this.author = "";
    this.publisher = "";
    this.year = 0;
    this.available = true;
    this.borrowerIds = new ArrayList<Integer>();
    }
    //Add the constructors accordingly (overload, to allow just int id etc)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    
    
    public List<Integer> getBorrowerIds() {
    return borrowerIds;
    }

    public void addBorrowerId(int memberId) {
        borrowerIds.add(memberId);
    }

    public void removeBorrowerId(int memberId) {
        borrowerIds.remove(memberId);
    }

    public boolean isBorrowed() {
        return !borrowerIds.isEmpty();
    }


/*
     public Member getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
    */
    public String toString() {
        return "(" + id + ") " + title + " by " + author + ", published by " + publisher + " in " + year +
                ", available=" + available + ".";
    }
    /*
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", year="
                + year + ", available=" + available + "]";
    }
    */
}
    
    
    
    //methods
    
    
    
    
    


