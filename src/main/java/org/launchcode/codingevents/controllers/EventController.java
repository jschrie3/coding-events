package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:/events";
    }


    // HANDLER METHODS
    // TODO CH14 EXERCISES #1: Create the two handler methods listed below in EventController. We’ll
    //  add code to these in a moment, so just put the method outline in place for now.

    // TODO CH14 EXERCISES #2: Add the necessary annotations to these methods for them to both live at
    //  the path /events/edit.

        // TODO CH14 EXERCISES #2A: Judging by the names of the handlers, which should handle GET requests and
        //  which should handle POST requests?

        // GET- It requests the data from a specified resource; DISPLAY HANDLER
        // POST- It submits the processed data to a specified resource; PROCESS HANDLER

        // TODO CH14 EXERCISES #2B: Remember, we’ve configured @RequestMapping with a URL segment on the controller
        //  class already.

        // TODO CH14 EXERCISES #2C: You’ll need to configure the route for displayEditForm to include the path variable
        //  eventId, so that paths like /events/edit/3 will work.

    // DISPLAY EDIT FORM
    // TODO CH14 EXERCISES #1A: Create a method to display an edit form with this signature:
    @GetMapping("edit/{eventId}") // lives at /events/edit
    public String displayEditForm(Model model, @PathVariable int eventId) {

        // TODO CH14 EXERCISES #5: Back in the displayEditForm handler, round out the controller method.
        // TODO CH14 EXERCISES #5A: Use an EventData method to find the event object with the given eventId.
        Event eventToEdit = EventData.getById(eventId);

        // TODO CH14 EXERCISES #5B: Put the event object in the model with .addAttribute().
        model.addAttribute("event", eventToEdit);

        // TODO CH14 EXERCISES #8: Back in the displayEditForm handler, add a title to model that reads “Edit Event NAME
        //  (id=ID)” where NAME and ID are replaced by the values for the given event.

        // create a string to hold the title
        String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
        model.addAttribute("title", title);

        // TODO CH14 EXERCISES #5C: Return the appropriate template string.
        return "events/edit";
    }

    // PROCESS EDIT FORM
    // TODO CH14 EXERCISES #1B: Create a method to process the form with this signature:
    @PostMapping("edit") // lives at /events/edit
    public String processEditForm(int eventId, String name, String description) {

        // TODO CH14 EXERCISES #9A: In processEditForm, Query EventData for the event being edited with the
        //  given id parameter.
        Event eventToEdit = EventData.getById(eventId);

        // TODO CH14 EXERCISES #9B: Update the name and description of the event with the appropriate model setter methods.
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);

        // TODO CH14 EXERCISES #9C: Redirect the user to /events (the event listing page).
        return "redirect:/events";
    }

}

