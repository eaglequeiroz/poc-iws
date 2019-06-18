package com.isobar.poc.controller;

import com.isobar.poc.model.Band;
import com.isobar.poc.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bandApi")
public class BandController {

    private BandService bandService;

    @Autowired
    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @GetMapping
    public List<Band> findAllBands() {
        return bandService.findAll();
    }

    @GetMapping("/{name}")
    public List<Band> findByName(@PathVariable("name") String name) {
        return bandService.findByName(name);
    }
}
