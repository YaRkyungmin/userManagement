package model.repository;

import model.User;
import model.exception.InvalidPasswordException;
import model.exception.UserNotFoundException;

import java.util.HashMap;

public class UserDAO {
    private HashMap<String, User> userDb = new HashMap<>();

    public void create(User user) {
        userDb.put(user.getId(), user);
    }

    public void update(User user) throws UserNotFoundException {
        if (!userDb.containsKey(user.getId())) {
            throw new UserNotFoundException(user.getId() + " not found.");
        }
        userDb.put(user.getId(), user);
    }

    public void delete(User user) throws UserNotFoundException {
        if (!userDb.containsKey(user.getId())) {
            throw new UserNotFoundException(user.getId() + " not found.");
        }
        userDb.remove(user.getId());
    }

    public void authenticate(User user) throws UserNotFoundException, InvalidPasswordException {
        User findUser = userDb.get(user.getId());

        if (findUser == null) {
            throw new UserNotFoundException(user.getId() + " not found.");
        }

        if (!findUser.getPassword().equals(user.getPassword())) {
            throw new InvalidPasswordException("Password for " + user.getId() + " is incorrect.");
        }
    }
}
