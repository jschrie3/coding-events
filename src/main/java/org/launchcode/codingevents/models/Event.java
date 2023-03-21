package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event {

    // create the event name
    private String name;
    private String description;
    // add unique identifier
    private int id;
    private static int nextId = 1; // start the counter

    // generate constructor
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        // initialize Id
        this.id = nextId;
        nextId++;
    }

    // generate getters and setters
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
    // just need a getter because we don't want users to be able to set the id
    public int getId() {
        return id;
    }

    // create toString method
    @Override
    public String toString() {
        // we just want it to return name
        return name;
    }

    // generate equals and hash methods
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
