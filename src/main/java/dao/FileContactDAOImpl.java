package dao;

import exception.ContactStorageException;
import exception.DuplicateContactException;
import exception.NameNotFoundException;
import model.Contact;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileContactDAOImpl implements ContactDAO{

    private Path filePath;

    @Override
    public List<Contact> findAll() throws ContactStorageException {

        try {
            List<String>  lines = Files.readAllLines(Path.of("dir/contactList.txt"));

        List<Contact> contacts = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                contacts.add(new Contact(parts[0].trim(), parts[1].trim()));
            }
        }
        return contacts;
        } catch (IOException e) {
            throw new ContactStorageException("Failed to load contacts from storage.", e);
        }

    }

    @Override
    public void save(Contact contact) throws DuplicateContactException {

        List<String> contactList = null;
        try {
            contactList = Files.readAllLines(Path.of("dir/contactList.txt"));

            for (String line : contactList) {
                String[] parts = line.split(",");

                if (parts.length >= 2) {
                    String phone = parts[1].trim();

                    if (phone.equalsIgnoreCase(contact.getPhoneNumber())) {
                        throw new DuplicateContactException("Duplicate Contact.");
                    }
                }
            }

            try (
                    BufferedWriter writer = Files.newBufferedWriter(
                        Path.of("dir/contactList.txt"),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                    );
            ) {
                writer.append(contact.getName() + ", " + contact.getPhoneNumber());
                writer.newLine();

            }
        } catch (IOException e) {
            throw new DuplicateContactException("Duplicate Contact.", e);
        }
    }

    @Override
    public List<Contact> findByName(String searchName) throws NameNotFoundException {

        try {
            List<String> lines = Files.readAllLines(Path.of("dir/contactList.txt"));

            List<Contact> matchedList = new ArrayList<>();

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    if (parts[0].equalsIgnoreCase(searchName)) {
                        matchedList.add(new Contact(parts[0].trim(), parts[1].trim()));
                    }
                }
            }
            if (matchedList.isEmpty()) {
                throw new NameNotFoundException("Contact not found.");
            }
            return matchedList;
        }
        catch (IOException e) {
            throw new NameNotFoundException("Name not found." , e);
        }
    }
}
