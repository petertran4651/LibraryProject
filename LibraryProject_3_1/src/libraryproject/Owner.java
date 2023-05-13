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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author salki
 */
public class Owner extends Person {
    public Owner(String name) {
        super(name);
    }
    
    private static final String USER_FILE = "C:\\Users\\echor\\Desktop\\user.txt";
    
    public static void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        String username = null;
        String password = null;
        boolean isValidInput = false;

        // Get valid username
        while (!isValidInput) {
            System.out.print("Enter new employee's username: ");
            username = scanner.nextLine();
            if (username.isEmpty()) {
                System.out.println("Invalid input. Please enter a non-empty username.");
            } else if (userExists(username)) {
                System.out.println("Username already exists. Please enter a different username.");
            } else {
                isValidInput = true;
            }
        }

        // Get valid password
        isValidInput = false;
        while (!isValidInput) {
            System.out.print("Enter new employee's password: ");
            password = scanner.nextLine();
            if (password.isEmpty()) {
                System.out.println("Invalid input. Please enter a non-empty password.");
            } else {
                isValidInput = true;
            }
        }

        // Add new employee to user.txt
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE, true));
            writer.write("employee-" + username + "," + password);
            writer.newLine();
            writer.close();
            System.out.println("Employee account created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to create employee account.");
        }
    }

    public static void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        boolean employeeRemoved = false;

        // Get username of employee to remove
        System.out.print("Enter username of employee to remove: ");
        String usernameToRemove = scanner.nextLine();

        // Read user.txt and remove line with specified username
        try {
            BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("employee-" + usernameToRemove)) {
                    lines.add(line);
                } else {
                    employeeRemoved = true;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to remove employee account.");
            return;
        }

        // Write updated user.txt
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE));
            for (String line : lines) {
                writer.write(line + "\n");
            }
            writer.close();
            if (employeeRemoved) {
                System.out.println("Employee account removed successfully!");
            } else {
                System.out.println("Employee account not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to remove employee account.");
        }
    }

    private static boolean userExists(String username) {
        boolean userExists = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("employee-" + username)) {
                    userExists = true;
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return true; // Assume user exists to avoid potential errors
        }
        return userExists;
    }
    
    public static void viewEmployees() {
    boolean foundEmployee = false;
    try {
        BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
        String line;
        System.out.println("Employees:");
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].startsWith("employee-")) {
                System.out.println(parts[0].substring(9));
                foundEmployee = true;
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Failed to read user accounts.");
        return;
    }
    if (!foundEmployee) {
        System.out.println("No employees found.");
    }
}
}

