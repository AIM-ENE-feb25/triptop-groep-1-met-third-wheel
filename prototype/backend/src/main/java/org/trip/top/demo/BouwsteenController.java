package org.trip.top.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.trip.top.demo.bouwsteen.Bouwsteen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bouwsteen")
public class BouwsteenController {
    private final BouwsteenService bouwsteenService;
    private Map<Integer, Bouwsteen> bouwstenen = new HashMap<>();

    @Autowired
    public BouwsteenController(BouwsteenService bouwsteenService){
        this.bouwsteenService = bouwsteenService;
        bouwstenen.put(1, new Bouwsteen("Hotel", 1));
    }

    @GetMapping
    public List<Bouwsteen> getAlleRestaurants(String locatie) {
        return bouwsteenService.getAlleRestaurantsOpLocatie(locatie);
    }

    @PostMapping("/{id}/pasAan")
    public String pasAan(@PathVariable int id) {
        getBouwsteen(id).pasAan();
        return getStatus(id);
    }

    @PostMapping("/{id}/regel")
    public String regel(@PathVariable int id) {
        getBouwsteen(id).regel();
        return getStatus(id);
    }

    @PostMapping("/{id}/betaal")
    public String betaal(@PathVariable int id) {
        getBouwsteen(id).betaal();
        return getStatus(id);
    }

    @PostMapping("/{id}/voerUit")
    public String voerUit(@PathVariable int id) {
        getBouwsteen(id).voerUit();
        return getStatus(id);
    }

    @PostMapping("/{id}/annuleer")
    public String annuleer(@PathVariable int id) {
        getBouwsteen(id).annuleer();
        return getStatus(id);
    }

    @GetMapping("/{id}/status")
    public String getStatus(@PathVariable int id) {
        return "Huidige status: " + getBouwsteen(id).getStatus();
    }

    private Bouwsteen getBouwsteen(int id) {
        return bouwstenen.getOrDefault(id, new Bouwsteen("Onbekend", id));
    }
}
