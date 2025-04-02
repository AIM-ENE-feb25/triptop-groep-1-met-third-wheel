package com.prototype_state.prototype.domain;

import com.prototype_state.prototype.domain.state.BouwsteenStatus;
import com.prototype_state.prototype.domain.state.Gepland;
import com.prototype_state.prototype.domain.state.IllegalStateActionException;

public class Bouwsteen {
    protected BouwsteenStatus status;
    protected String naam;
    protected int id;

    public Bouwsteen(String naam, int id) {
        this.naam = naam;
        this.id = id;
        this.status = null;
    }
    public BouwsteenStatus getStatus() {
        return status;
    }

    public String setStatus(BouwsteenStatus newStatus) {
        var statusUpdate = "Status veranderd naar: " + newStatus.getStatusName();
        this.status = newStatus;
        return statusUpdate;
    }
    public void plan() {
        setStatus(new Gepland());
    }

    private void controleerBouwsteenStatus() {
        if (status == null)
            throw new IllegalStateActionException(
                    "Bouwsteen moet eerst gepland worden voordat er acties ondernomen kunnen worden.");
    }

    public void pasAan() {
        controleerBouwsteenStatus();
        status.pasAan(this);
    }

    public void regel() {
        controleerBouwsteenStatus();
        status.regel(this);
    }

    public void betaal() {
        controleerBouwsteenStatus();
        status.betaal(this);
    }

    public void voerUit() {
        controleerBouwsteenStatus();
        status.voerUit(this);
    }

    public void annuleer() {
        controleerBouwsteenStatus();
        status.annuleer(this);
    }
}