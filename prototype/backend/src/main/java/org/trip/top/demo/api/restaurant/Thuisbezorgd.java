package org.trip.top.demo.api.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.trip.top.demo.bouwsteen.RestaurantBouwsteen;
import org.trip.top.demo.services.KaartenService;

@Component
public class Thuisbezorgd extends RestaurantAPI {
    @Autowired
    public Thuisbezorgd(KaartenService kaartenService){
        this.kaartenService = kaartenService;
    }
    @Override
    public RestaurantBouwsteen voerAPICallUit(String value) {
        return new RestaurantBouwsteen(
                2,
                "De halve maan",
                "test.nl",
                "Restaurant in Amsterdam",
                kaartenService.getCoordinaten("Amsterdam"));
    }
}
