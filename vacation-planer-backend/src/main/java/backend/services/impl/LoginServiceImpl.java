package backend.services.impl;

import backend.entities.User;
import backend.entities.UserType;
import backend.repositories.UserRepository;
import backend.services.AuthServiceBase;
import backend.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Objects.nonNull;

@Service
public class LoginServiceImpl extends AuthServiceBase implements LoginService {
    @Autowired
    private UserRepository userRepository;

    private static final ThreadLocal<Long> currentUser = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    public void setLoggedInUserId(Long userId) {
        currentUser.set(userId);
    }

    public Long getLoggedInUserId() {
        return currentUser.get();
    }

    public boolean login(String username, String password, UserType userType) {
        // Check for null or empty username and password
        boolean isNotNull = nonNull(username) && nonNull(password);
        boolean isNotEmpty = !(username.isEmpty()) && !(password.isEmpty());

        if (isNotNull && isNotEmpty) {
            // Find the user by username
            User userByUsername = userRepository.findByUsername(username);

            if (nonNull(userByUsername)) {
                // Check if the user is of the correct type
                if (userByUsername.getUserType() != userType) {
                    logger.error("Login failed: Incorrect user type for " + username);
                    return false;
                }

                // User found, log success and validate password
                logger.info("Login successful. Welcome back, " + userByUsername.getUsername());
                setLoggedInUserId(userByUsername.getId());
                currentUser.set(userByUsername.getId());
                // Compare stored password with input password
                return userByUsername.getPassword().equals(password);
            }
        }

        // If username or password is incorrect, log the error
        logger.error("Login failed: Username or password are incorrect. Please try again.");
        return false;
    }
}