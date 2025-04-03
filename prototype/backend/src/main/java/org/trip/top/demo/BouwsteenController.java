package org.trip.top.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trip.top.demo.bouwsteen.Bouwsteen;
import org.trip.top.demo.bouwsteen.RouteBouwsteen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bouwsteen")
public class BouwsteenController {
    private final BouwsteenService bouwsteenService;

    @Autowired
    public BouwsteenController(BouwsteenService bouwsteenService, MockBouwsteenRepository mockBouwsteenRepository){
        this.bouwsteenService = bouwsteenService;
    }

    @GetMapping("/restaurant")
    public List<Bouwsteen> getAlleRestaurants(@RequestParam String locatie) {
        return bouwsteenService.getAlleRestaurantsOpLocatie(locatie);
    }

    @GetMapping("/route")
    public List<Bouwsteen> getRouteBouwsteen(@RequestParam int id) {
        return bouwsteenService.getRouteNaarBouwsteen(id);
    }

    @PostMapping("/{id}/plan")
    public String plan(@PathVariable int id) {
        return bouwsteenService.planBouwsteen(id);
    }

    @PostMapping("/{id}/pasAan")
    public String pasAan(@PathVariable int id) {
        return bouwsteenService.pasBouwsteenAan(id);
    }

    @PostMapping("/{id}/regel")
    public String regel(@PathVariable int id) {
        return bouwsteenService.regelBouwsteen(id);
    }

    @PostMapping("/{id}/betaal")
    public String betaal(@PathVariable int id) {
        return bouwsteenService.betaalBouwsteen(id);
    }

    @PostMapping("/{id}/voerUit")
    public String voerUit(@PathVariable int id) {
        return bouwsteenService.voerBouwsteenUit(id);
    }

    @PostMapping("/{id}/annuleer")
    public String annuleer(@PathVariable int id) {
        return bouwsteenService.annuleerBouwsteen(id);
    }

    @GetMapping("/{id}/status")
    public String getStatus(@PathVariable int id) {
        return bouwsteenService.getStatus(id);
    }
}
