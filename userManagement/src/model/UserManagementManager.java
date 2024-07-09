package model;

import console.ConsoleService;
import model.exception.ExceptionHandler;
import model.exception.InvalidInputException;
import model.exception.InvalidPasswordException;
import model.exception.UserNotFoundException;
import service.UserService;

public final class UserManagementManager {
    private boolean isStartService = true;
    private User loginedUser = null;
    private final ConsoleService consoleService = new ConsoleService();
    private final UserService userService = new UserService();
    public void startUserManagementService() {
        while (isStartService) {
            try {
                controlMenu();
            } catch (InvalidInputException exception) {
                ExceptionHandler.handleInvalidInputException(exception);
            } catch (UserNotFoundException exception) {
                ExceptionHandler.handleUserNotFoundException(exception);
            } catch (InvalidPasswordException exception) {
                ExceptionHandler.handleInvalidPasswordException(exception);
            }
        }
    }

    private void controlMenu() throws InvalidInputException, UserNotFoundException, InvalidPasswordException {
        consoleService.showMenu();
        switch (consoleService.receiveMessage()) {
            case "1":
                joinUser();
                break;
            case "2":
                loginUser();
                break;
            case "3":
                updateUser();
                break;
            case "4":
                withdrawUser();
                break;
            case "0":
                exit();
                break;
            default:
                throw new InvalidInputException("Invalid input.");
        }
    }

    private User configureUser() throws  InvalidInputException {
        String[] parts = consoleService.receiveMessage().split(" ");

        if (parts.length == 2) {
            String id = parts[0];
            String password = parts[1];
            return new User(id, password);
        } else {
            throw new InvalidInputException("Invalid input.");
        }
    }

    private void joinUser() throws InvalidInputException {
        consoleService.showRegisterMessage();
        User user = configureUser();
        userService.register(user);
        consoleService.showWecomeMessage(user.getId());
    }

    private void loginUser() throws InvalidInputException, UserNotFoundException, InvalidPasswordException {
        consoleService.showLoginMessage();
        User user = configureUser();
        userService.login(user);
        loginedUser = user;
    }

    private void updateUser() throws UserNotFoundException, InvalidInputException {
        if (loginedUser == null) {
            consoleService.warningLoginMessage();
        } else {
            consoleService.showUpdateMessage();
            userService.updateAccount(configureUser());
            consoleService.showUpdateCompleteMessage(loginedUser.getId());
        }
    }

    private void withdrawUser() throws UserNotFoundException {
        if (loginedUser == null) {
            consoleService.warningLoginMessage();
        } else {
            userService.removeAccount(loginedUser);
            consoleService.showEmitMessage(loginedUser.getId());
            loginedUser = null;
        }
    }

    private void exit() {
        isStartService = false;
    }
}
