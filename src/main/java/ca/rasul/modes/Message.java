package ca.rasul.modes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
public class Message {

    private final String message;

    @JsonCreator
    public Message(@JsonProperty("message") String message) {
        this.message = message;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }
}
