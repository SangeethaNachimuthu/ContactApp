package dao;

import exception.ContactStorageException;
import exception.DuplicateContactException;
import exception.NameNotFoundException;
import model.Contact;

import java.io.IOException;
import java.util.List;

public interface ContactDAO {

    List<Contact> findAll() throws ContactStorageException;

    void save(Contact contact)
            throws ContactStorageException, DuplicateContactException;

    List<Contact> findByName(String name)
            throws ContactStorageException, NameNotFoundException;
}
