package de.fraulyoner.mitetimetracker.timetracking;

import java.io.Serializable;

class TimeEntryWrapper implements Serializable {

    private TimeEntry time_entry_group;

    public TimeEntry getTime_entry_group() {
        return time_entry_group;
    }

    public void setTime_entry_group(TimeEntry time_entry_group) {
        this.time_entry_group = time_entry_group;
    }
}
