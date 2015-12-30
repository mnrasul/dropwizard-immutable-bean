package ca.rasul.auth;

import ca.rasul.models.User;
import io.dropwizard.auth.Authorizer;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
public class UserAuthorizer<P> implements Authorizer<User>{
    /**
     * Decides if access is granted for the given principal in the given role.
     *
     * @param principal a {@link Principal} object, representing a user
     * @param role      a user role
     * @return {@code true}, if the access is granted, {@code false otherwise}
     */
    @Override
    public boolean authorize(User principal, String role) {
        return true;
    }
}
