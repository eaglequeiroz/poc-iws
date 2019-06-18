package com.isobar.poc.service;

import com.isobar.poc.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Cacheable(value = {"bands"})
public class BandService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${externalUrl}")
    private String externalEndpoint;

    public List<Band> findAll() {
        Band[] bands = restTemplate.getForObject(externalEndpoint, Band[].class);
        return Arrays.asList(bands);
    }

    public List<Band> findByName(String name) {
        List<Band> bands = findAll();
        bands = bands.stream().filter(band -> band.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        return bands;
    }
}
