package org.trip.top.demo.api.kaarten;

import org.springframework.stereotype.Component;
import org.trip.top.demo.Locatie;
import org.trip.top.demo.api.API;

import java.util.List;

@Component
public class TrueWayDirection extends API<String, Locatie> {

    public List<String> getRouteBeschrijvingen() {
        return List.of("Ga rechtdoor tot ...", "Ga rechtsaf", "Ga rechtdoor", "Bestemming aan linkerkant");
    }

    @Override
    public String voerAPICallUit(Locatie s) {
        return "Amsterdam";
    }
}
