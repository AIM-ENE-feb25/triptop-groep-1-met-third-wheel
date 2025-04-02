package org.trip.top.demo.bouwsteen;

import org.trip.top.demo.Locatie;
import org.trip.top.demo.bouwsteen.state.BouwsteenStatus;
import org.trip.top.demo.bouwsteen.state.Gepland;

public abstract class Bouwsteen {
    private BouwsteenStatus status;
    protected String naam;
    private int id;
    protected String type;
    protected String link;
    protected String info;
    protected Locatie locatie;

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

    public String getNaam() {
        return naam;
    }

    public String getType() {
        return type;
    }

    public String getLink() {
        return link;
    }

    public String getInfo() {
        return info;
    }

    public Locatie getLocatie() {
        return locatie;
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
