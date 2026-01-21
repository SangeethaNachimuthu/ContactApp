package controller;

import dao.ContactDAO;
import exception.DuplicateContactException;
import exception.NameNotFoundException;
import view.ContactView;

import java.io.IOException;

public class ContactController {

    private ContactDAO dao;
    private ContactView view;

    public ContactController(ContactDAO dao, ContactView view) {
        this.dao = dao;
        this.view = view;
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
                        view.displayMessage("save");
                    } catch (DuplicateContactException e) {
                        view.displayError("duplicate");
                    } catch (IOException e) {
                        view.displayError("io:" + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        view.displayAllContacts(dao.findAll());
                    } catch (IOException e) {
                        view.displayError("io:" + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        dao.findByName(view.getName());
                    } catch (IOException e) {
                        view.displayError("io:" + e.getMessage());
                    } catch (NameNotFoundException e) {
                        view.displayError("name");
                    }
                    break;
                case 0:
                    running = false;
                    view.displayMessage("exit");
                    break;
                default:
                    view.displayMessage("default");
            }

        }
    }
}
