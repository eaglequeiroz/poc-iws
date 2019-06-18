package com.isobar.poc.controller;

import com.isobar.poc.model.Band;
import com.isobar.poc.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/bandApi")
public class BandController {

    private BandService bandService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${externalUrl}")
    private String externalEndpoint;

    @Autowired
    public BandController(BandService bandService) {
        this.bandService = bandService;
    }


    @PostMapping
    public List<Band> createDataFromExternalEndpoint() {
        List<Object> objectList = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(externalEndpoint, Object[].class)));
        List<Band> bandList = (List<Band>)(List<?>) objectList;
        return bandService.createRegistersByExternalEndpoint(bandList);
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
