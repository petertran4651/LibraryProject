/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author salki
 */
public class Library {
    private static List<Book> books;
    private static List<Member> members;
    private List<Employee> employees;
    private Map<Book, Integer> bookCount;
    private static List<BorrowedBook> borrowedBooks;
    private static Member currentMember;
    private static final int MAX_BORROWED_BOOKS = 3;
    private static final String USER_FILE = "C:\\Users\\salki\\OneDrive\\Documents\\users.txt";
    private static final String LIBRARY_FILE = "C:\\Users\\salki\\OneDrive\\Documents\\library.txt";
    
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        employees = new ArrayList<>();
        bookCount = new HashMap<>();
        currentMember = null;
    }
    
    
    public Library(List<Book> books, List<Member> members, List<Employee> employees) {
    this.books = books;
    this.members = members;
    this.employees = employees;
    this.bookCount = new HashMap<>();
    this.borrowedBooks = new ArrayList<>();
    
    // Initialize book count map with all books and their counts set to zero
    for (Book book : books) {
        this.bookCount.put(book, 0);
    }
}
    
    

   
    
    //Employee methods:
    
  public static void addBook() {
    Scanner input = new Scanner(System.in);
    try {
        System.out.print("Enter book title: ");
        String title = input.nextLine();

        System.out.print("Enter author: ");
        String author = input.nextLine();

        System.out.print("Enter Id: ");
        int bookId = input.nextInt();
        input.nextLine();

        // check if book with given ID already exists
        boolean bookExists = false;
        for (Book book : books) {
            if (book.getId() == bookId) {
                bookExists = true;
                break;
            }
        }
        if (bookExists) {
            System.out.println("Book with ID " + bookId + " already exists in the library.");
            return;
        }

        System.out.print("Enter publisher: ");
        String publisher = input.nextLine();

        System.out.print("Enter year published: ");
        int yearPublished = input.nextInt();
        input.nextLine();


        Book newBook = new Book(title, author, bookId, publisher, yearPublished);
        books.add(newBook);

        // write book information to library.txt
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(LIBRARY_FILE, true));
            writer.write(newBook.getTitle() + "," + newBook.getAuthor() + "," + newBook.getId() + "," +
                    newBook.getPublisher() + "," + newBook.getYear());
            writer.close();
            System.out.println("New book " + title + " added to the library.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to add book to library.");
        }

    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid integer for Id, year published, and number of copies.");
    }
}
    
    
  public static void removeBook() {
    Scanner input = new Scanner(System.in);
    try {
        System.out.print("Enter ID of book to remove: ");
        int bookId = input.nextInt();
        input.nextLine();

        // find book with given ID
        boolean bookFound = false;
        int indexToRemove = -1;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId() == bookId) {
                bookFound = true;
                indexToRemove = i;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book with ID " + bookId + " not found in the library.");
            return;
        }

        // remove book from books list
        Book removedBook = books.remove(indexToRemove);

        // remove book from library.txt file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(LIBRARY_FILE));
            StringBuilder sb = new StringBuilder();

            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[2]) != bookId) {
                    sb.append(line).append('\n');
                }
                line = reader.readLine();
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(LIBRARY_FILE));
            writer.write(sb.toString());
            writer.close();

            System.out.println("Book " + removedBook.getTitle() + " removed from the library.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to remove book from library.");
        }

    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid integer for book ID.");
    }
}
    
    
    
    
public static void registerMember() {
    Scanner input = new Scanner(System.in);

    System.out.println("\n===== REGISTER NEW MEMBER =====");
    System.out.print("Enter member name: ");
    String name = input.nextLine();

    Member newMember = new Member(name);
    members.add(newMember);

    System.out.println("\nMember successfully registered.");
    
    try {
        FileWriter writer = new FileWriter(USER_FILE, true);
        writer.write("member-" + newMember.getName() + "\n");
        writer.write(System.lineSeparator()); // write newline character
        writer.close();
        System.out.println("\nMember successfully registered.");
    } catch (IOException e) {
        System.out.println("\nAn error occurred while writing to the file. Member registration failed.");
    }
}
    

public static void removeMember() {
    Scanner input = new Scanner(System.in);

    System.out.println("\n===== REMOVE MEMBER =====");
    System.out.print("Enter member name: ");
    String memberName = input.nextLine();

    boolean memberFound = false;
    for (Iterator<Member> iterator = members.iterator(); iterator.hasNext();) {
        Member member = iterator.next();
        if (member.getName().equalsIgnoreCase(memberName)) {
            iterator.remove();
            memberFound = true;
            break;
        }
    }

    if (memberFound) {
        try {
            FileWriter writer = new FileWriter(USER_FILE, false);

            // write updated member list to file
            for (Member member : members) {
                writer.write("member-" + member.getName() + "\n");
                writer.write(System.lineSeparator());
            }

            writer.close();
            System.out.println("\nMember with name " + memberName + " successfully removed.");
        } catch (IOException e) {
            System.out.println("\nAn error occurred while writing to the file. Member removal failed.");
        }
    } else {
        System.out.println("\nMember with name " + memberName + " not found in the library.");
    }
}
    
public static void viewMembersList() {
    System.out.println("\n===== MEMBER LIST =====");
    try {
        BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
        String line;
        boolean hasMembers = false;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].startsWith("member-")) {
                String name = parts[0].substring(7);
                String id = parts[1];
                System.out.println("Name: " + name + ", ID: " + id);
                hasMembers = true;
            }
        }
        reader.close();
        if (!hasMembers) {
            System.out.println("No members registered.");
        }
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Failed to read user accounts.");
    }
} 
    
    
 
    
    
    
    
    //Member methods: 
    


public static void viewBooks() {
    System.out.println("\n===== BOOKS IN LIBRARY =====");
    if (books.isEmpty()) {
        System.out.println("No books available in the library.");
    } else {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
    
  public static void borrowBook() {
    Scanner input = new Scanner(System.in);
    System.out.println("\n===== BORROW BOOK =====");
    viewBooks();

    System.out.print("\nEnter the ID of the book you want to borrow: ");
    int bookId = input.nextInt();

    // check if book is available
    boolean bookFound = false;
    Book borrowedBook = null;
    for (Book book : books) {
        if (book.getId() == bookId) {
            if (book.isAvailable()) {
                borrowedBook = book;
                bookFound = true;
                break;
            } else {
                System.out.println("The book is not available for borrowing.");
                return;
            }
        }
    }

    if (!bookFound) {
        System.out.println("Book not found.");
        return;
    }

    // check if member has not exceeded maximum number of borrowed books
    if (currentMember.getBorrowedBooks().size() >= MAX_BORROWED_BOOKS) {
        System.out.println("You have exceeded the maximum number of borrowed books.");
        return;
    }

    // add book to member's borrowed books list and update book's availability
    currentMember.addBorrowedBook(borrowedBook);
    borrowedBook.addBorrowerId(currentMember.getId());
    borrowedBook.setAvailable(false);
    System.out.println("The book has been borrowed successfully.");
}


public static void searchBook() {
    Scanner input = new Scanner(System.in);

    System.out.println("\n===== SEARCH BOOK =====");
    System.out.print("Enter search query: ");
    String query = input.nextLine();

    List<Book> filteredBooks = new ArrayList<>();
    for (Book book : books) {
        if (book.getTitle().toLowerCase().contains(query.toLowerCase()) || book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
            filteredBooks.add(book);
        }
    }

    if (filteredBooks.size() > 0) {
        System.out.println("\nSearch results:");
        for (Book book : filteredBooks) {
            System.out.println(book);
        }
    } else {
        System.out.println("\nNo results found.");
    }
}

}

/*
public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            int count = bookCount.get(book);
            if (count > 0) {
                System.out.println(book + " - Copies Available: " + count);
            }
        }
    }

    public void displayMembers() {
        System.out.println("Library Members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public void displayEmployees() {
        System.out.println("Library Employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public boolean issueBook(Book book, Member member) {
        int count = bookCount.getOrDefault(book, 0);
        if (count > 0) {
            bookCount.put(book, count - 1);
            member.addBook(book);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(Book book, Member member) {
        int count = bookCount.getOrDefault(book, 0);
        if (member.hasBook(book) && count >= 0) {
            bookCount.put(book, count + 1);
            member.removeBook(book);
            return true;
        } else {
            return false;
        }
    }
    
    */