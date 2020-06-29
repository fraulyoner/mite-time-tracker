package de.fraulyoner.mitetimetracker.account;

import java.io.Serializable;

class Account implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
