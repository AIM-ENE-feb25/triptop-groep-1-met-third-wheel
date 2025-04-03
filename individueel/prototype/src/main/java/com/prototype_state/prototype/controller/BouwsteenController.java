package com.prototype_state.prototype.controller;

import com.prototype_state.prototype.domain.Bouwsteen;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/bouwsteen")
@RestController
class BouwsteenController {
    private Map<Integer, Bouwsteen> bouwstenen = new HashMap<>();

    public BouwsteenController() {
        bouwstenen.put(1, new Bouwsteen("Hotel", 1));
    }

    @PostMapping("/{id}/plan")
    public String plan(@PathVariable int id) {
        getBouwsteen(id).plan();
        return getStatus(id);
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
        if(getBouwsteen(id).getStatus() == null) {
            return "Huidige status: " + getBouwsteen(id).getStatus();
        }else{
            return "Huidige status: " + getBouwsteen(id).getStatus().getStatusName();
        }
    }

    private Bouwsteen getBouwsteen(int id) {
        return bouwstenen.getOrDefault(id, new Bouwsteen("Onbekend", id));
    }
}
