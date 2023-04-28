/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryproject;

/**
 *
 * @author salki
 */
abstract class LibraryItem  {
    private int id;
    private String title;
    private String author;
    private String type;
    private int year;

    public LibraryItem(int id, String title, String author, String type, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", Type: " + getType() + ", Year: " + getYear();
    }
}
