package de.fraulyoner.mitetimetracker.timetracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TimeEntriesController {

    @Value("${mite.api.apiKey}")
    private String apiKey;

    @Value("${mite.api.baseUrl}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/time")
    public String time(Model model) {

        String url = baseUrl + "time_entries.json?group_by=day,customer&api_key=" + apiKey;

        ResponseEntity<TimeEntryWrapper[]> response =
                restTemplate.getForEntity(
                        url,
                        TimeEntryWrapper[].class);
        TimeEntryWrapper[] timeEntries = response.getBody();
        List<TimeEntry> timeEntriesList = new ArrayList<>();

        if (timeEntries != null) {
            for (TimeEntryWrapper w : timeEntries) {
                TimeEntry timeEntry = w.getTime_entry_group();
                timeEntriesList.add(timeEntry);
            }
        }

        model.addAttribute("entries", timeEntriesList);
        return "time";
    }


}