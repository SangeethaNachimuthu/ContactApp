package controller;

import dao.ContactDAO;
import exception.ExceptionHandler;
import model.Contact;
import view.ContactView;

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
            try {
                view.displayMenu();
                int choice = view.readChoice();

                switch (choice) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        displayAll();
                        break;
                    case 3:
                        findByName();
                        break;
                    case 0:
                        running = false;
                        view.displayMessage("Good Bye. Thanks for using the Contact App.");
                        break;
                    default:
                        view.displayMessage("Invalid Option. Try again.");
                }
            } catch (Exception e) {
                handler.handle(e);
            }
        }
    }

    private void addContact() throws Exception {

        dao.save(view.getUserInput());
        view.displayMessage("Contact Saved Successfully!");
    }

    private void displayAll() throws Exception {

        view.displayContacts(dao.findAll());
    }

    private void findByName() throws Exception {

        List<Contact> contacts = (dao.findByName(view.getName()));
        view.displayContacts(contacts);
    }
}
