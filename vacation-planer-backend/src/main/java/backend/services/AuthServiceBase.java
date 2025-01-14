package backend.services;

import backend.exceptions.UnAuthorizedException;

import java.util.Objects;

public abstract class AuthServiceBase {
    protected Long loggedInUserId;

    protected void ensureLoggedIn(Long userId) {
        if (!Objects.equals(loggedInUserId, userId)) {
            throw new UnAuthorizedException("Access denied: Please log in first!");
        }
    }

    public void setLoggedInUserId(Long userId) {
        this.loggedInUserId = userId;
    }
}
