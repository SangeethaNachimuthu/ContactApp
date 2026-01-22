package exception;

public class ExceptionHandler {

    public void handle(Exception e) {
        if (e instanceof  ContactStorageException){
            System.out.println("System error: " + e.getMessage());
        }
        else if (e instanceof DuplicateContactException) {
            System.out.println("System error: " + e.getMessage());
        }
        else if (e instanceof NameNotFoundException) {
            System.out.println("System error: " + e.getMessage());
        }
        else {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
