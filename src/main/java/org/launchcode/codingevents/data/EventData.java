package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    // FIELDS
    // need a place to put events
    // make a map - static (there will only be one); our map will store the IDs (int) and events
    // final - once the map is initiated it cannot change, only the data inside it can change
    private static final Map<Integer, Event> events = new HashMap<>();

    // METHODS
    // all static because we're not creating instances of them
    // add an event
    public static void add(Event event) {
        // use .put to add a new event and it's id to the hashmap
        events.put(event.getId(), event);
    }

    // get a single event
    // returns an event object that matches the id passed into the method
    public static Event getById(int id) {
        return events.get(id);
    }

    // get all events
    // don't need parameters because we're returning all events as collection
    // we don't need the keys (id), we want the jobs (values)
    public static Collection<Event> getAll() {
        return events.values();
    }

    // remove an event
    public static void remove(int id) {
        // extracts a single event from the map
        events.remove(id);
    }

}
