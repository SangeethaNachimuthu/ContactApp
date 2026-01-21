import controller.ContactController;
import dao.ContactDAO;
import dao.FileContactDAOImpl;
import view.ContactView;

public class Main {

    ContactDAO dao = new FileContactDAOImpl();
    ContactView view = new ContactView();

    ContactController controller = new ContactController(dao, view);

    public void main(String[] args) {

        controller.run();
    }
}
