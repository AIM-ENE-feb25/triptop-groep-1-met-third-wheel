package org.trip.top.demo.api.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.trip.top.demo.bouwsteen.RestaurantBouwsteen;
import org.trip.top.demo.services.KaartenService;

@Component
public class UberEats extends RestaurantAPI {
    @Autowired
    public UberEats(KaartenService kaartenService) {
        this.kaartenService = kaartenService;
    }

    @Override
    public RestaurantBouwsteen voerAPICallUit(String value) {
        return new RestaurantBouwsteen(
                3,
                "De hele maan",
                "test.nl",
                "Nieuw restaurant in Amsterdam",
                kaartenService.getCoordinaten("Amsterdam"));
    }
}
