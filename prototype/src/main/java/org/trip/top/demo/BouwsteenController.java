package org.trip.top.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trip.top.demo.bouwsteen.Bouwsteen;

import java.util.List;

@RestController
@RequestMapping("/bouwsteen")
public class BouwsteenController {
    private final BouwsteenService bouwsteenService;

    @Autowired
    public BouwsteenController(BouwsteenService bouwsteenService){
        this.bouwsteenService = bouwsteenService;
    }

    @GetMapping
    public List<Bouwsteen> getAlleRestaurants(String locatie) {
        return bouwsteenService.getAlleRestaurantsOpLocatie(locatie);
    }
}
