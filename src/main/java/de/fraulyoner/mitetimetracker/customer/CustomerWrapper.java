package de.fraulyoner.mitetimetracker.customer;

import java.io.Serializable;

class CustomerWrapper implements Serializable {

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
