package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Bay
 */

// CHAPTER 13 EXERCISES: 13.10.2. Expanding our Events Schedule

@Controller
@RequestMapping("events")
public class EventController {

    // TODO 2: In the videos, we learned how to use templates to display the elements in a static
    //  list called events. Let’s make our events list a HashMap! This enables us to add
    //  descriptions to our events.

//    private static List<String> events = new ArrayList<>();

    // change events list to events hashmap
    private static HashMap<String, String> events = new HashMap<>();

    // TODO 1: Comment out your previous code in the displayAllEvents method.
//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("title", "All Events");
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }


    // TODO 3: Fill your events HashMap with the names and descriptions of 3 coding events around town.

    // update displayAllEvents for events hashmap
    @GetMapping
    public String displayAllEvents(Model model){
        HashMap<String, String> events = new HashMap<>();
        events.put("Menteaship","A fun meetup for connecting with mentors");
        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
        events.put("Javascripty", "An imaginary meetup for Javascript developers");
        // create a model to pass data into a view
        model.addAttribute("events", events);
        // need to iterate over hashmap to get key/value pairs
        for (Map.Entry<String, String> event : events.entrySet()) {
            model.addAttribute("name", event.getKey());
            model.addAttribute("address", event.getValue());
        }
        return "events/index"; // return template at events/index
    }

    // comment out previous processCreateEventForm since it's acting on an arraylist object
//    @PostMapping("create")
//    public String processCreateEventForm(@RequestParam String eventName) {
//        events.add(eventName);
//        return "redirect:";
//    }

    //update processCreateEventForm for events hashmap
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, String eventDesc) {
        events.put(eventName, eventDesc);
        return "redirect:/events";
    }

    // TODO (IN EVENTS/INDEX.HTML): Using th:block and th:each, put together the events and their descriptions in a table as opposed to an unordered list.

    // TODO (IN TEMPLATES/FRAGMENTS.HTML): Use fragments to store the address of the new tech hub where all of the programmers are hanging out. Use th:replace in your main template to bring in the address as a third column in your table. You may need to create a new fragments.html.

    // TODO (IN STATIC/STYLES.CSS): Add some CSS to style your table to make it easier to read and center it on the page. You may need to create a new styles.css as well. Make sure to connect styles.css to the appropriate template with th:href.

}







// commented out to make sure code matches starter code for CHAPTER 13 EXERCISES

//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;

//@Controller
//@RequestMapping("events") // everything at path /events
//public class EventController {
//
//    // FIELDS
//    // make a global event variable so all methods in class can use
//    private static List<String> events = new ArrayList<>();

    // METHODS
//    @GetMapping
//    public String displayAllEvents(Model model){
//        List<String> events = new ArrayList<>();
//        events.add("Code with Pride");
//        events.add("Strange Loop");
//        events.add("Apple WWDC");
//        events.add("StringOne Platform");
//        // create a model to pass data into a view
//        model.addAttribute("events", events);
//        return "events/index"; // return template at events/index
//    }
//
//    // reworked in 13.6.6. to add static list events to the global events list
//    @GetMapping
//    public String displayAllEvents(Model model){
//        // create a model to pass data into a view
//        model.addAttribute("events", events);
//        return "events/index"; // return template at events/index
//    }
//
//    // create a new handler
//    @GetMapping("create") // lives at /events/create
//    public String renderCreateEventForm(){
//        return "events/create";
//    }
//
//    // create a new handler to handle requests for the form
//    @PostMapping("create") // lives at /events/create - can live at same path as renderCreateEventForm because one is a get and one is a post request
//    public String createEvent(@RequestParam String eventName) { // RequestParam takes data
//        // take eventName input and put in a list of events
//        events.add(eventName); // the global variable events list will get this new event
//        // show updated list after events added
//        return "redirect:/events"; // tells the browser to redirect to the route of the controller (/events)
//
//    }
//}
