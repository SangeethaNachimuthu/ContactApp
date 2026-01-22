package view;

import model.Contact;

import java.util.List;
import java.util.Scanner;

public class ContactView {

    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {

        System.out.println("----- Contact App -----");
        System.out.println("1. Add contact");
        System.out.println("2. Display All Contacts");
        System.out.println("3. Find Contact by Name");
        System.out.println("0. Exit");
    }

    public int readChoice() {

        System.out.print("\nSelect the option: ");
        return scanner.nextInt();
    }

    public Contact getUserInput() {

        String name = IO.readln("Enter Name: ");
        String phoneNumber = IO.readln("Enter PhoneNumber: ");

        return new Contact(name, phoneNumber);
    }

    public String getName() {

        return IO.readln("Enter Name: ");
    }

    public void displayContacts(List<Contact> contacts) {

        System.out.println("\nAll Contacts:");
        for (Contact c : contacts) {
            System.out.println(c.getName() + ", " + c.getPhoneNumber());
        }
        System.out.println();
    }

      public void displayContact(Contact contact) {
            if (contact == null) {
                System.out.println("Contact not found.");
            } else {
                System.out.println("Found : " + contact);
            }
      }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.err.println(message);
    }
}
