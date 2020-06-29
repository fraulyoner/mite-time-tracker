package de.fraulyoner.mitetimetracker.timetracking;

import java.time.LocalDate;

class TimeEntry {

    private int minutes;
    private LocalDate day;
    private String customer_name;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public float getDuration() {

        return (float) minutes / 60;
    }
}
