package exception;

public class ExceptionHandler {

    public void handle(Exception e) {

        System.out.println("An error occurred: " + e.getMessage());
    }
}
