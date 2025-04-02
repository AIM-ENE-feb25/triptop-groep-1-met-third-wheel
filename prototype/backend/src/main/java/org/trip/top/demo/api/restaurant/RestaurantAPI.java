package org.trip.top.demo.api.restaurant;

import org.springframework.stereotype.Component;
import org.trip.top.demo.api.APIMetLocatie;
import org.trip.top.demo.bouwsteen.RestaurantBouwsteen;

@Component
public abstract class RestaurantAPI extends APIMetLocatie<RestaurantBouwsteen,String> {}
