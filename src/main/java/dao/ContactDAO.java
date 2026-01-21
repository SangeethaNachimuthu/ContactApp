package dao;

import model.Contact;
import java.util.List;

public interface ContactDAO {

    public List<Contact> findAll();
    public void save(Contact contact);
    public Contact findByName(String name);
}
