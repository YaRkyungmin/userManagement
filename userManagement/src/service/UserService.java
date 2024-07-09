package service;

import model.User;
import model.exception.InvalidPasswordException;
import model.exception.UserNotFoundException;
import model.repository.UserDAO;

public class UserService {
    UserDAO userDAO = new UserDAO();
    public void register(User user) {
        userDAO.create(user);
    }

    public void updateAccount(User user) throws UserNotFoundException {
        userDAO.update(user);
    }

    public void removeAccount(User user) throws UserNotFoundException {
        userDAO.delete(user);
    }

    public void login(User user) throws UserNotFoundException, InvalidPasswordException {
        userDAO.authenticate(user);
    }
}
