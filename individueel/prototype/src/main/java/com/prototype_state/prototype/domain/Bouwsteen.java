package com.prototype_state.prototype.domain;

import com.prototype_state.prototype.domain.state.BouwsteenStatus;
import com.prototype_state.prototype.domain.state.Gepland;

public class Bouwsteen {
    private BouwsteenStatus status;
    private String naam;
    private int id;

    public Bouwsteen(String naam, int id) {
        this.naam = naam;
        this.id = id;
        this.status = new Gepland();
    }

    public String setStatus(BouwsteenStatus newStatus) {
        var statusUpdate = "Status veranderd naar: " + newStatus.getStatusName();
        System.out.println(statusUpdate);
        this.status = newStatus;
        return statusUpdate;
    }

    public Bouwsteen pasAan() {
        return status.pasAan(this);
    }

    public void regel() {
        status.regel(this);
    }

    public void betaal() {
        status.betaal(this);
    }

    public void voerUit() {
        status.voerUit(this);
    }

    public void annuleer() {
        status.annuleer(this);
    }

    public String getStatus() {
        return status.getStatusName();
    }

}