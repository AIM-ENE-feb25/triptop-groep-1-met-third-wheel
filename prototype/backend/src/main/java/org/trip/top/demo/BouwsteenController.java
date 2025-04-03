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
    private final MockBouwsteenRepository mockBouwsteenRepository;

    @Autowired
    public BouwsteenController(BouwsteenService bouwsteenService, MockBouwsteenRepository mockBouwsteenRepository){
        this.bouwsteenService = bouwsteenService;
        this.mockBouwsteenRepository = mockBouwsteenRepository;
    }

    @GetMapping("/restaurant")
    public List<Bouwsteen> getAlleRestaurants(@RequestParam String locatie) {
        return bouwsteenService.getAlleRestaurantsOpLocatie(locatie);
    }

    @GetMapping("/route")
    public List<Bouwsteen> getRouteBouwsteen(@RequestParam int id) {
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        return bouwsteenService.getRouteNaarBouwsteen(bouwsteen);
    }

    @PostMapping("/{id}/plan")
    public String plan(@PathVariable int id) {
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        bouwsteen.plan();
        mockBouwsteenRepository.saveBouwsteen(bouwsteen);
        return getStatus(id);
    }

    @PostMapping("/{id}/pasAan")
    public String pasAan(@PathVariable int id) {
        mockBouwsteenRepository.getBouwsteenById(id).pasAan();
        return getStatus(id);
    }

    @PostMapping("/{id}/regel")
    public String regel(@PathVariable int id) {
        mockBouwsteenRepository.getBouwsteenById(id).regel();
        return getStatus(id);
    }

    @PostMapping("/{id}/betaal")
    public String betaal(@PathVariable int id) {
        mockBouwsteenRepository.getBouwsteenById(id).betaal();
        return getStatus(id);
    }

    @PostMapping("/{id}/voerUit")
    public String voerUit(@PathVariable int id) {
        mockBouwsteenRepository.getBouwsteenById(id).voerUit();
        return getStatus(id);
    }

    @PostMapping("/{id}/annuleer")
    public String annuleer(@PathVariable int id) {
        mockBouwsteenRepository.getBouwsteenById(id).annuleer();
        return getStatus(id);
    }

    @GetMapping("/{id}/status")
    public String getStatus(@PathVariable int id) {
        if(mockBouwsteenRepository.getBouwsteenById(id).getStatus() == null) {
            return "Huidige status: " + mockBouwsteenRepository.getBouwsteenById(id).getStatus();
        }else{
            return "Huidige status: " + mockBouwsteenRepository.getBouwsteenById(id).getStatus().getStatusName();
        }
    }
}
