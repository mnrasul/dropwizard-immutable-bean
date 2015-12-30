package ca.rasul.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.ws.rs.FormParam;

/**
 * @author Nasir Rasul {@literal nasir@rasul.ca}
 */
public class Message {

    private final String message;

    @JsonCreator
    public Message(@FormParam("message") String message) {
        this.message = message;
    }

//    @JsonProperty("message")
    @FormParam("message")
    public String getMessage() {
        return message;
    }
}
