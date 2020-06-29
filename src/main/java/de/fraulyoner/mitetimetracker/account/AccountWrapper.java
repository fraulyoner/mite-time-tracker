package de.fraulyoner.mitetimetracker.account;

import java.io.Serializable;

class AccountWrapper implements Serializable {

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
