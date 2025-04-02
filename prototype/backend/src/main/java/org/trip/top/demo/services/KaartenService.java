package org.trip.top.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trip.top.demo.Locatie;
import org.trip.top.demo.api.kaarten.GoogleMapsPlaces;
import org.trip.top.demo.api.kaarten.TrueWayDirection;
import org.trip.top.demo.bouwsteen.Bouwsteen;
import org.trip.top.demo.bouwsteen.RouteBouwsteen;

import java.util.List;

@Service
public class KaartenService implements ApiService {
    private final GoogleMapsPlaces googleMapsPlaces;
    private final TrueWayDirection trueWayDirection;

    @Autowired
    public KaartenService(GoogleMapsPlaces googleMapsPlaces, TrueWayDirection trueWayDirection){
        this.googleMapsPlaces = googleMapsPlaces;
        this.trueWayDirection = trueWayDirection;
    }
    public String getAdress(Locatie locatie) {
        return trueWayDirection.voerAPICallUit(locatie);
    }

    public Locatie getCoordinaten(String adress) {
        return googleMapsPlaces.voerAPICallUit(adress);
    }

    @Override
    public List<Bouwsteen> getBouwstenen(String locatie){
        RouteBouwsteen route = new RouteBouwsteen("Reis van Amsterdam naar restaurant de Maan",
                "test",
                "Test routebeschrijving",
                getCoordinaten(locatie),
                trueWayDirection.getRouteBeschrijvingen());
        return List.of(route);
    }
}
