package ca.rasul;

import ca.rasul.auth.BasicAuthenticator;
import ca.rasul.auth.UnAuthorizedResourceHandler;
import ca.rasul.auth.UserAuthorizer;
import ca.rasul.models.User;
import ca.rasul.resources.MessageResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthFilter;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.UnauthorizedHandler;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
public class MyApplication extends Application<MyConfiguration> {
    @Override
    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        environment.jersey().register(MessageResource.class);
        registerAuthRelated(environment);
    }

    private void registerAuthRelated(Environment environment) {
        UnauthorizedHandler unauthorizedHandler = new UnAuthorizedResourceHandler();
        AuthFilter basicAuthFilter = new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new BasicAuthenticator())
                .setAuthorizer(new UserAuthorizer())
                .setRealm("shire")
                .setUnauthorizedHandler(unauthorizedHandler)
                .setPrefix("Basic")
                .buildAuthFilter();

        environment.jersey().register(new AuthDynamicFeature(basicAuthFilter));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder(User.class));

        environment.jersey().register(unauthorizedHandler);

    }
    public static void main (String args[]) throws Exception {
        new MyApplication().run(args);
    }
}
