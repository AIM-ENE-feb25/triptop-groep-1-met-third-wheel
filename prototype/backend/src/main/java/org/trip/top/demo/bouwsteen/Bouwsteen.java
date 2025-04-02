package org.trip.top.demo.bouwsteen;

import org.trip.top.demo.Locatie;
import org.trip.top.demo.bouwsteen.state.BouwsteenStatus;
import org.trip.top.demo.bouwsteen.state.Gepland;
import org.trip.top.demo.bouwsteen.state.IllegalStateActionException;

public abstract class Bouwsteen {
    protected BouwsteenStatus status;
    protected String naam;
    protected int id;
    protected String type;
    protected String link;
    protected String info;
    protected Locatie locatie;

    public Bouwsteen() {
        this.status = null;
    }

    public Bouwsteen(String naam, int id) {
        this.naam = naam;
        this.id = id;
        this.status = null;
    }

    public String setStatus(BouwsteenStatus newStatus) {
        this.status = newStatus;
        return "Status veranderd naar: " + newStatus.getStatusName();
    }

    public int getId() {
        return id;
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

    public BouwsteenStatus getStatus() {
        return status;
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
