package dao;

import model.Contact;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileContactDAOImpl implements ContactDAO{

    private Path filePath;

    @Override
    public List<Contact> findAll() {
        return List.of();
    }

    @Override
    public void save(Contact contact) {

        try (
                BufferedWriter writer = Files.newBufferedWriter(
                    Path.of("dir/contactList.txt"),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
                );
        ) {
            writer.append(contact.getName());
            writer.append(", ");
            writer.append(contact.getPhoneNumber());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Contact findByName(String name) {
        return null;
    }
}
