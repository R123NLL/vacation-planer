package backend.services;

import backend.entities.UserType;

public interface LoginService {
    boolean login(String username, String password, UserType userType);
}
