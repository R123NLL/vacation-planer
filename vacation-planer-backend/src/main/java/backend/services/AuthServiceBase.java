package backend.services;

import backend.exceptions.UnAuthorizedException;

import java.util.Objects;

public abstract class AuthServiceBase {
    private static final ThreadLocal<Long> currentUser = new ThreadLocal<>();

    protected void setLoggedInUserId(Long userId) {
        currentUser.set(userId);
    }

    protected Long getLoggedInUserId() {
        return currentUser.get();
    }

    protected void ensureLoggedIn(Long userId) {
        if (!Objects.equals(getLoggedInUserId(), userId)) {
            throw new UnAuthorizedException("Access denied: Please log in first!");
        }
    }

    protected void clearLoggedInUser() {
        currentUser.remove();
    }
}
