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
public class Member extends Person {
    private int id;
    private String password;
    private List<Book> borrowedBooks;
    
    public Member(String name, int id) {
        super(name);
        this.id = id;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }
    
    public Member(String name) {
        super(name);
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public int getNumBorrowedBooks() {
        return borrowedBooks.size();
    }
    
    @Override
    public String getName() {
        return super.getName() + this.password;
    }
}
    /*
    public ArrayList<BorrowedBook> getBorrowedBooks(Library library) {
        return library.getBorrowedBooksByMember(this);
    }

    public void addBorrowedBook(BorrowedBook borrowedBook, Library library) {
        library.addBorrowedBook(borrowedBook);
    }

    public void removeBorrowedBook(BorrowedBook borrowedBook, Library library) {
        library.removeBorrowedBook(borrowedBook);
    }

    public boolean hasBorrowedBook(Book book, Library library) {
        for (BorrowedBook borrowedBook : library.getBorrowedBooksByMember(this)) {
            if (borrowedBook.getBook().equals(book)) {
                return true;
            }
        }
        return false;
    }
    */

/*The borrowed book system would work as follows:

When a member borrows a book, a new BorrowedBook object is created with the Book object and Member object as parameters.
The BorrowedBook object is added to the member's borrowedBooks ArrayList using the addBorrowedBook() method of the Member class.
The Book object's availability status is set to false using the setAvailable() method.
When a member returns a book, the BorrowedBook object is removed from the member's borrowedBooks ArrayList using the removeBorrowedBook() method of the Member class.
The Book object's availability status is set to true using the setAvailable() method.
*/