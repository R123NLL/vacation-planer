package backend.services;


import backend.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User addHUser(User user);
    void deleteUser(Long userId);
}
