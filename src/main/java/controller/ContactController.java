package controller;

import dao.ContactDAO;
import view.ContactView;

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
                    dao.save(view.getUserInput());
                    break;
                case 2:
                    dao.findAll();
                    break;
                case 3:
                    dao.findByName(view.getName());
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    view.displayMessage();
            }

        }
    }
}
