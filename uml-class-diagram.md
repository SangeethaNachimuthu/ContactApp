```mermaid
classDiagram

    namespace model {
        class Contact {
            -String name
            -String phoneNumber
            +Contact(String name, String phoneNumber)
            +getName() String
            +setName(String name) void
            +getPhoneNumber() String
            +setPhoneNumber(String phoneNumber) void
        }
    }

    namespace dao {
        class ContactDAO {
            <<interface>>
            +findAll() List~Contact~
            +save(Contact contact) void
            +findByName(String name) List~Contact~
        }
        class FileContactDAOImpl {
            -Path filePath
        }
    }

    namespace view {
        class ContactView {
            +getUserInput() Contact
            +displayMenu() void
            +readChoice() int
            +getName() String
            +displayAllContacts(List~Contact~ contacts) void
            +displayByName(List~Contact~ contacts) void
            +displayMessage(String message) void
            +displayError(String message) void
        }
    }

    namespace controller {
        class ContactController {
            -ContactDAO dao
            -ContactView view
            -ExceptionHandler handler
            +ContactController(ContactDAO dao, ContactView view)
            +run() void
        }
    }

    namespace exception {
        class ContactStorageException { }
        class DuplicateContactException { }
        class NameNotFoundException { }
        class ExceptionHandler {
            +handle(Exception e)$ void
        }
    }

    class Main {
        +main(String[] args)
    }

    Main --> ContactController
    ContactDAO <|.. FileContactDAOImpl
    ContactController --> ContactDAO : uses
    ContactController --> ContactView : updates
    ContactController ..> ExceptionHandler : delegates errors
    
    %% Package Dependencies (MVC Flow)
    ContactDAO ..> Contact : manages
    FileContactDAOImpl ..> Contact : persists
    
    %% Exceptions
    Contact ..> IllegalArgumentException : throws
    FileContactDAOImpl ..> ContactStorageException : throws
    FileContactDAOImpl ..> DuplicateContactException : throws
````