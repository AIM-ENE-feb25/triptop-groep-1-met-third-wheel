package org.trip.top.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trip.top.demo.api.restaurant.RestaurantAPI;
import org.trip.top.demo.bouwsteen.Bouwsteen;
import org.trip.top.demo.bouwsteen.RestaurantBouwsteen;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService implements ApiService {
    private final List<RestaurantAPI> apis;

    @Autowired
    public RestaurantService(List<RestaurantAPI> apis){
        this.apis = apis;
    }

    @Override
    public List<Bouwsteen> getBouwstenen(String locatie) {
        List<Bouwsteen> bouwstenen = new ArrayList<>();
        for (RestaurantAPI api : apis){
            bouwstenen.add(api.voerAPICallUit(locatie));
        }
        return bouwstenen;
    }
}
