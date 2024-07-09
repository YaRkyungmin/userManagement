package model.exception;

public class ExceptionHandler {
    public static void handleUserNotFoundException(UserNotFoundException exception) {
        System.out.println("error: " + exception.getMessage());
    }

    public static void handleInvalidInputException(InvalidInputException exception) {
        System.out.println("error: " + exception.getMessage());
    }

    public static void handleInvalidPasswordException(InvalidPasswordException exception) {
        System.out.println("error: " + exception.getMessage());
    }
}
