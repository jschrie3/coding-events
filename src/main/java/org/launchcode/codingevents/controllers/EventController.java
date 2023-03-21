package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:";
    }

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
