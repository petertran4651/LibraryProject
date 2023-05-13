/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libraryproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author salki
 */
public class LibraryProject {
    private static final String USER_FILE = "C:\\Users\\echor\\Desktop\\user.txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    

    // Read the usernames and passwords from a file
    Map<String, String> loginInfo = readLoginInfoFromFile(USER_FILE);

    // Prompt the user to select between owner, member, etc login
    boolean loggedIn = false;
    String userType = null;
    while (!loggedIn) {
        System.out.println("Please select a login type");
        System.out.println("1. Owner");
        System.out.println("2. Employee");
        System.out.println("3. Member");
        System.out.println("4. Create Member Account");
        System.out.print("Enter your choice: ");
        try {
            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                userType = "owner";
                loggedIn = true;
                break;
            case 2:
                userType = "employee";
                loggedIn = true;
                break;
            case 3:
                userType = "member";
                loggedIn = true;
                break;
            case 4:
                createMemberAccount(loginInfo);
                continue;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume invalid input
            continue; // go back to start of loop
        }
    }

    // Prompt the user to login
    loggedIn = false;
    String username = null;
    while (!loggedIn) {
        System.out.print("Username: ");
        try {
            username = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Password: ");
        String password = null;
        try {
            password = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (loginInfo.containsKey(userType + "-" + username) && loginInfo.get(userType + "-" + username).equals(password)) {
            System.out.println("Login successful!");
            loggedIn = true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    // Call appropriate method from Library class based on user's choice
    switch (userType) {
        case "owner":
            MenuManager.ownerMenu();
            break;
        case "employee":
            MenuManager.employeeMenu();
            break;
        case "member":
            MenuManager.memberMenu();
            break;
        default:
            System.out.println("Invalid user type.");
            break;
    }
}
    
   
    private static void createMemberAccount(Map<String, String> loginInfo) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    if (loginInfo.containsKey("member-" + username)) {
        System.out.println("Username already exists. Please try again with a different username.");
        return;
    }

    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    // Add the new member's login info to the loginInfo map
    loginInfo.put("member-" + username, password);

    // Write the new login info to the user.txt file
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true));
        writer.write("member-" + username + "," + password);
        //skips line in the txt file
        writer.newLine();
        writer.close();
        System.out.println("Member account created successfully!");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error creating member account. Please try again.");
    }
    
    System.out.println();
}
    
    //NOTE TO SELF: USER.TXT MUST INCLUDE A SKIPPED LINE BY HAND IN ORDER TO WORK (SPENT 40 MINS TRYING TO FIGURE THIS OUT) 
    
     private static Map<String, String> readLoginInfoFromFile(String fileName) {
        Map<String, String> loginInfo = new HashMap<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                loginInfo.put(tokens[0], tokens[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return loginInfo;
    }
}
