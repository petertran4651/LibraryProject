/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author salki
 */
public class MenuManager {
    
  public static void memberMenu() {
    Scanner input = new Scanner(System.in);
    int choice = 0;

    do {
        System.out.println("\n===== MEMBER MENU =====");
        System.out.println("1. View Books");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Search Book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                Library.viewBooks();
                break;
            case 2:
                
                Library.borrowBook();
                break;
                
            case 3:
               /* Library.returnBook();
                break; */
            case 4:
                Library.searchBook();
                break;
            case 5:
                System.out.println("Thank you for using the library system.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 5);
    }
    
  public static void employeeMenu() {
    Scanner input = new Scanner(System.in);
    int choice = 0;

    do {
        System.out.println("\n===== EMPLOYEE MENU =====");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Register Member");
        System.out.println("4. Remove Member");
        System.out.println("5. View Members");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                Library.addBook();
                break;
            case 2:
                Library.removeBook();
                break;

            case 3:
                Library.registerMember();
                break;

            case 4:
                Library.removeMember();
                break;
            case 5:
                Library.viewMembersList();
                break;
            case 6:
                System.out.println("Thank you for using the library system.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 6);
}
 
  public static void ownerMenu() {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Welcome, owner!");
    boolean exit = false;
    
    while (!exit) {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Add employee");
        System.out.println("2. Remove employee");
        System.out.println("3. View all employees");
        System.out.println("4. Logout");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            
            switch (choice) {
                case 1:
                    Owner.addEmployee();
                    break;
                case 2:
                    Owner.removeEmployee();
                    break;
                case 3:
                    Owner.viewEmployees();
                    break;
                case 4:
                    System.out.println("Logging out...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // consume invalid input
        }
    }
}
}
