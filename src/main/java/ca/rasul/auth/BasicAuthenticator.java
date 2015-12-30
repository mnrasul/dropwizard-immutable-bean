package ca.rasul.auth;

import ca.rasul.models.User;
import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 * */
public class BasicAuthenticator<C, P> implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        //do no authentication yet. Let all users through
        return Optional.fromNullable(new User(credentials.getUsername(), credentials.getPassword()));
    }
}

