package dao;

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
    public List<Contact> findAll() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("dir/contactList.txt"));
        List<Contact> contacts = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                contacts.add(new Contact(parts[0].trim(), parts[1].trim()));
            }
        }
        return contacts;
    }

    @Override
    public void save(Contact contact) throws IOException, DuplicateContactException {

        List<String> contactList = Files.readAllLines(Path.of("dir/contactList.txt"));

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
    }

    @Override
    public List<Contact> findByName(String searchName) throws IOException, NameNotFoundException {

        List<String> lines = Files.readAllLines(Path.of("dir/contactList.txt"));
        List<Contact> matchedList = new ArrayList<>();

        return matchedList;
    }
}
