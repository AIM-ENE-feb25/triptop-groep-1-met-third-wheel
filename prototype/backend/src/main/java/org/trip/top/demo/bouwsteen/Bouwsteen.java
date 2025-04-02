package org.trip.top.demo.bouwsteen;

import org.trip.top.demo.Locatie;

public abstract class Bouwsteen {
    protected String naam;
    protected String type;
    protected String link;
    protected String info;
    protected Locatie locatie;

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
}
