package ca.rasul;

import ca.rasul.resources.MessageResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
public class MyApplication extends Application<MyConfiguration> {
    @Override
    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        environment.jersey().register(MessageResource.class);
    }


    public static void main (String args[]) throws Exception {
        new MyApplication().run(args);
    }
}
