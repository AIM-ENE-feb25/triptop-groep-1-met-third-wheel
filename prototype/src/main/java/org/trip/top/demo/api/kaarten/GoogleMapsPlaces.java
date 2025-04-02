package org.trip.top.demo.api.kaarten;


import org.springframework.stereotype.Component;
import org.trip.top.demo.Locatie;
import org.trip.top.demo.api.API;

@Component
public class GoogleMapsPlaces extends API<Locatie, String> {

    @Override
    public Locatie voerAPICallUit(String o) {
        return new Locatie("52.3745403", "4.89797550561798");
    }
}
