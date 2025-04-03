package com.prototype_state.prototype.controller;

import com.prototype_state.prototype.service.BouwsteenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/bouwsteen")
@RestController
class BouwsteenController {
    private BouwsteenService bouwsteenService;

    @Autowired
    public BouwsteenController(BouwsteenService bouwsteenService) {
        this.bouwsteenService = bouwsteenService;
    }


    @PostMapping("/{id}/plan")
    public String plan(@PathVariable int id) {
        return bouwsteenService.plan(id);
    }

    @PostMapping("/{id}/pasAan")
    public String pasAan(@PathVariable int id) {
        return bouwsteenService.pasAan(id);
    }

    @PostMapping("/{id}/regel")
    public String regel(@PathVariable int id) {
        return bouwsteenService.regel(id);
    }

    @PostMapping("/{id}/betaal")
    public String betaal(@PathVariable int id) {
        return bouwsteenService.betaal(id);
    }

    @PostMapping("/{id}/voerUit")
    public String voerUit(@PathVariable int id) {
        return bouwsteenService.voerUit(id);
    }

    @PostMapping("/{id}/annuleer")
    public String annuleer(@PathVariable int id) {
        return bouwsteenService.annuleer(id);
    }

    @GetMapping("/{id}/status")
    public String getStatus(@PathVariable int id) {
        return bouwsteenService.getStatus(id);
    }
}
