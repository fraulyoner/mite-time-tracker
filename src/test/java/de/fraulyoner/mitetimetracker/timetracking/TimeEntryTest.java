package de.fraulyoner.mitetimetracker.timetracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeEntryTest {

    @Test
    void ensureCalculatesCorrectDurationInHoursForMoreThanOneHour() {

        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setMinutes(120);

        Assertions.assertEquals(2, timeEntry.getDuration(), "Wrong duration");

    }

    @Test
    void ensureCalculatesCorrectDurationInHoursForLessThanOneHour() {

        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setMinutes(15);

        Assertions.assertEquals(0.25, timeEntry.getDuration(), "Wrong duration");

    }

    @Test
    void ensureCalculatesCorrectDurationInHoursForZeroTime() {

        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setMinutes(0);

        Assertions.assertEquals(0, timeEntry.getDuration(), "Wrong duration");

    }
}