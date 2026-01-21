package dao;

import model.Contact;

import java.nio.file.Path;
import java.util.List;

public class FileContactDAOImpl implements ContactDAO{

    private Path filePath;

    @Override
    public List<Contact> findAll() {
        return List.of();
    }

    @Override
    public void save(Contact contact) {

    }

    @Override
    public Contact findByName(String name) {
        return null;
    }
}
