package ca.rasul.resources;

import ca.rasul.MyApplication;
import ca.rasul.MyConfiguration;
import ca.rasul.models.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
public class MessageResourceTest {
    public final String config =  "/Users/nasir/sources/dropwizard-immutable-bean/config.yml";
    @Rule
    public final DropwizardAppRule<MyConfiguration> RULE =  new DropwizardAppRule(MyApplication.class, config);

    @Test
    public void testMessage() throws Exception {
        Form form = new Form();
        form.param("message", "message in a bottle");

        Response response = target().path("/").request(MediaType.APPLICATION_JSON_TYPE)
                .acceptLanguage("en_US").post(Entity.form(form));
        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getLanguage()).isEqualTo(Locale.ENGLISH);
    }
    protected WebTarget target(){
        Client client = new JerseyClientBuilder(RULE.getEnvironment()).build("test client");
        return client.target(String.format("http://localhost:%d", RULE.getLocalPort()));
    }

    @Test
    public void testJackson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(new Message("message in a bottle"));
        String expected = "{\"message\":\"message in a bottle\"}";
        Assert.assertEquals(expected, s);

        Message message = mapper.readValue(expected, Message.class);
        Assert.assertEquals(message.getMessage(), "message in a bottle");
    }

}