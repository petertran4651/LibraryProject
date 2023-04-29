# LibraryProject

Initial file submitted was contributed equally, by all three members:
Methods/main: Marco
IO implementation for most methods: Daolin
Classes//main: Peter

The project consists of a library management system
able to be operated from three perspectives: the owner,
the librarian and the member.

Upon starting the program, the user will be greeted with
4 different options:
  1. Owner's login
  2. Employee's login
  3. Member's login
  4. Create Member Account

The login page detects names with specific prefixes within
the user.txt file and gives access to an menu according
to the prefix associated with a name.
Names in user.txt are meant to follow the following format:
prefix-Username,password 

 ex.:
    owner-Marco,test
    employee-Peter,hi
    member-Daolin,lol

The owner's username and password are meant to be included
within the user.txt file used beforehand for storing data.
"Create Member Account", requests the user for a username
and password, which is then sent to the USER_FILE with a
"member-" prefix

The owner's menu allows for the following operations to be
performed by users with the "owner-" prefix: 

    1. Add employee       (adds an employee account by inputting username and password)
    2. Remove employee    (removes an employee by inputting the name)
    3. View all employees (displays all employees within the USER_FILE)
    4. Logout             (logs the owner out of their account)


The employee's menu allows for the following operations to be
performed by users with the "employee-" prefix in the USER_FILE:

    1. Add Book           (adds a book to a LIBRARY_FILE)
    2. Remove Book        (removes a book from the LIBRARY_FILE using the bookID and the book's name)
    3. Register Member    (Adds a member to the USER_FILE by inputting a name and a password)
    4. Remove Member      (Removes a member to the USER_FILE using a name and unique Id)
    5. View Members       (displays all users with the prefix of member within the USER_FILE)
    6. Exit               (Logs the employee out of the system can closes the program)

The members's menu allows for the following operations to be
performed by users with the "member-" prefix in the USER_FILE:

    1. View Books         (displays every book within the LIBRARY_FILE
    2. Borrow Book        (allows the user to borrow a book max = 3)
    3. Return Book        (allows the user to return the book)
    4. Search Book        (searches for a book within the library using a query)
    5. Exit               (Logs the member out of the system can closes the program)




Current implementations:

  Exception Handling:
      Mainly used in the event of an input mismatch (I.E writing a String
      instead of an integer within the menu)
      
  IO:
      Used for storing data on books and users with their respective roles
      in two seperate txt files.
      
  Inheritance:
      A "Person" class is attributed to all types of users
  
  Method overriding:
      The getName function which is present in the "Person" class changes
      depending on the sub-class. The "to-string" method does this for
      the displays of the users in the USER_FILE.
      
 Method overloading (in progress):
     Multiple different constructors to allows multiple inputs for employees
     and members.
     
 Multiple primitive datatypes:
     (see code)
     
 
Future implementations:

  Limited display for LIBRARY_FILE:
      Coding the "View Books" methods so that it displays only a specific
      amount of books at any time (multiple pages to browse through the
      library
      
  Sorting:
      We intend on adding sorting for the USER_FILE and the LIBRARY_FILE
      in order to place roles and books within the library alphabetically.
      
 Additional IO functionality:
      IO functionality for the methods that are currently unable to work
      with IO, such as search.
      
 Path file bug fix:
      Fixing the occasional error caused by the inclusion of a space within
      the USER_FILE that occurs upon the project's startup.
