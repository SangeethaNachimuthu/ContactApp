package controller;

import dao.ContactDAO;
import exception.ContactStorageException;
import exception.DuplicateContactException;
import exception.ExceptionHandler;
import exception.NameNotFoundException;
import model.Contact;
import view.ContactView;

import java.io.IOException;
import java.util.List;

public class ContactController {

    private final ContactDAO dao;
    private final ContactView view;
    private final ExceptionHandler handler;

    public ContactController(ContactDAO dao, ContactView view) {
        this.dao = dao;
        this.view = view;
        handler = new ExceptionHandler();
    }

    public void run() {

        boolean running = true;

        while (running) {

            view.displayMenu();
            int choice = view.readChoice();

            switch (choice) {
                case 1:
                    try {
                        dao.save(view.getUserInput());
                        view.displayMessage("Contact Saved Successfully!");
                    } catch (DuplicateContactException e) {
                        view.displayError("Duplicate Contact.\n");
                    } catch (IOException e) {
                        handler.handle(e);
                    }
                    break;
                case 2:
                    try {
                        view.displayContacts(dao.findAll());
                    } catch (ContactStorageException e) {
                        handler.handle(e);
                    }
                    break;
                case 3:
                    try {
                        List<Contact> contacts = (dao.findByName(view.getName()));
                        view.displayContacts(contacts);
                    } catch (NameNotFoundException e) {
                        System.out.println();
                        view.displayError("Name not found");
                    }  catch (IOException e) {
                        handler.handle(e);
                    }
                    break;
                case 0:
                    running = false;
                    view.displayMessage("Good Bye. Thanks for using the Contact App.");
                    break;
                default:
                    view.displayMessage("Invalid Option. Try again.");
            }

        }
    }
}
