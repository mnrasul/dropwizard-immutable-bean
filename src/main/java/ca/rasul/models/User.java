package ca.rasul.models;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
public class User implements Principal {
    private final String username;
    private final String password;

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the name of this principal.
     *
     * @return the name of this principal.
     */
    @Override
    public String getName() {
        return username;
    }

    /**
     * Returns true if the specified subject is implied by this principal.
     * <p>
     * <p>The default implementation of this method returns true if
     * {@code subject} is non-null and contains at least one principal that
     * is equal to this principal.
     * <p>
     * <p>Subclasses may override this with a different implementation, if
     * necessary.
     *
     * @param subject the {@code Subject}
     * @return true if {@code subject} is non-null and is
     * implied by this principal, or false otherwise.
     * @since 1.8
     */
    @Override
    public boolean implies(final Subject subject) {
        return true;
    }
}
