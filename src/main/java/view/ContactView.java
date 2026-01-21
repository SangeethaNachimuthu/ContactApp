package view;

import model.Contact;

import java.util.Scanner;

public class ContactView {

    Scanner scanner = new Scanner(System.in);

    public String getUserInput(String prompt) {

        return "";
    }

    public void displayMenu() {

        System.out.println("Contact App");
        System.out.println("------------");
        System.out.println("1. Add contact");
        System.out.println("2. Display All Contacts");
        System.out.println("3. Find Contact by Name");
        System.out.println("0. Exit");

    }

    public int readChoice() {

        int choice;
        System.out.print("\nSelect the option: ");
        return choice = scanner.nextInt();
    }

    public Contact getUserInput() {

        String name = IO.readln("Enter Name: ");
        String phoneNumber = IO.readln("Enter PhoneNumber: ");

        return new Contact(name, phoneNumber);
    }

    public String getName() {

        return IO.readln("Enter Name: ");
    }

    public void displayMessage(String message) {
        if (message.equalsIgnoreCase("save")) {
            System.out.println("Contact added successfully\n");
        }
        else if (message.equalsIgnoreCase("all")) {
            System.out.println("All Contacts:");
        }
        else if (message.equalsIgnoreCase("exit")) {
            System.out.println("Good Bye, Thanks for using Contact App.");
        }
        else {
            System.out.println("Invalid option. Try again!");
        }
    }

    public void displayError(String message) {

        if (message.equalsIgnoreCase("duplicate")) {
            System.out.println("Duplicate Contact.\n");
        }
        else {
            System.out.println("File Error: " + message.substring(3) + "\n");
        }
    }
}
