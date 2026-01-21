import controller.ContactController;
import dao.ContactDAO;
import dao.FileContactDAOImpl;
import exception.DuplicateContactException;
import view.ContactView;

import java.io.IOException;

public class Main {

    ContactDAO dao = new FileContactDAOImpl();
    ContactView view = new ContactView();

    ContactController controller = new ContactController(dao, view);

    public void main(String[] args) {

        controller.run();
    }
}
