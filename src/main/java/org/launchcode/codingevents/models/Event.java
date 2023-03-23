package org.launchcode.codingevents.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    // add validation annotation; cannot be blank
    @NotBlank(message = "Event Name cannot be blank!")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    // add validation annotation; can be blank
    @Size(max = 500, message = "Description too long!")
    private String description;

    // add validation annotation; recognized as an email, cannot be blank
    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    public Event(String name, String description, String contactEmail) {
        // add new fields to constructor
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.id = nextId;
        nextId++;
    }

    // create no-arg constructor to be used in create template
    public Event() {}

    // add getters and setters for new fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}