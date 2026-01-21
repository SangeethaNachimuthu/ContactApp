package dao;

import exception.DuplicateContactException;
import model.Contact;

import java.io.IOException;
import java.util.List;

public interface ContactDAO {

    public void findAll() throws IOException;

    public void save(Contact contact)
            throws IOException, DuplicateContactException;

    public Contact findByName(String name);
}
