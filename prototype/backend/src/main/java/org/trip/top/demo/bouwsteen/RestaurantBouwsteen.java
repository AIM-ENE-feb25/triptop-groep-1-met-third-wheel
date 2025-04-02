package org.trip.top.demo.bouwsteen;

import org.trip.top.demo.Locatie;

public class RestaurantBouwsteen extends Bouwsteen {
    private RestaurantBouwsteen() {
        type = "Restaurant";
    }

    public RestaurantBouwsteen(int id, String naam, String link, String info, Locatie locatie) {
        this.id = id;
        this.naam = naam;
        this.link = link;
        this.info = info;
        this.locatie = locatie;
    }
}
