package org.trip.top.demo.bouwsteen;


import org.trip.top.demo.Locatie;

import java.util.List;

public class RouteBouwsteen extends Bouwsteen{
    private List<String> instructies;
    private RouteBouwsteen() {
        type = "Route";
    }

    public RouteBouwsteen(String naam, String link, String info, Locatie locatie, List<String> instructies) {
        this.naam = naam;
        this.link = link;
        this.info = info;
        this.locatie = locatie;
        this.instructies = instructies;
    }

    public List<String> getInstructies() {
        return instructies;
    }
}
