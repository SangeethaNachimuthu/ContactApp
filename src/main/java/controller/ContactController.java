package controller;

import dao.ContactDAO;
import exception.DuplicateContactException;
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
                    view.displayMessage("all");
                    try {
                        dao.findAll();
                    } catch (IOException e) {
                        view.displayError("io:" + e.getMessage());
                    }
                    break;
                case 3:
                    dao.findByName(view.getName());
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
