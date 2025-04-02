package org.trip.top.demo.bouwsteen;

import org.trip.top.demo.Locatie;

public class RestaurantBouwsteen extends Bouwsteen {
    private RestaurantBouwsteen() {
        type = "Restaurant";
    }

    public RestaurantBouwsteen(String naam, String link, String info, Locatie locatie) {
        this.naam = naam;
        this.link = link;
        this.info = info;
        this.locatie = locatie;
    }
}
