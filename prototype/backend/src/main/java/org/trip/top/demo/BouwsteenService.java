package org.trip.top.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trip.top.demo.bouwsteen.Bouwsteen;
import org.trip.top.demo.services.ApiService;
import org.trip.top.demo.services.RestaurantService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BouwsteenService {
    private final List<ApiService> apiServices;

    @Autowired
    public BouwsteenService(List<ApiService> apiServices) {
        this.apiServices = apiServices;
    }


    public List<Bouwsteen> getAlleRestaurantsOpLocatie(String locatie) {
        List<Bouwsteen> bouwstenen = new ArrayList<>();
        System.out.println(apiServices);
        for (ApiService service : apiServices){
            if (service instanceof RestaurantService){
                bouwstenen.addAll(service.getBouwstenen(locatie));
            }
        }

        return bouwstenen;
    }
}
