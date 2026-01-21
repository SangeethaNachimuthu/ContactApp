package dao;

import exception.DuplicateContactException;
import exception.NameNotFoundException;
import model.Contact;

import java.io.IOException;
import java.util.List;

public interface ContactDAO {

    public List<Contact> findAll()
            throws IOException;

    public void save(Contact contact)
            throws IOException, DuplicateContactException;

    public List<Contact> findByName(String name)
            throws IOException, NameNotFoundException;
}
