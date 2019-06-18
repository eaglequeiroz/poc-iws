package com.isobar.poc.service;

import com.isobar.poc.model.Band;
import com.isobar.poc.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BandService {

    @Autowired
    private BandRepository bandRepository;

    public List<Band> findAll() {
        Band[] bands = bandRepository.getRemote();
        return Arrays.asList(bands);
    }

    public List<Band> findByName(String name) {
        List<Band> bands = findAll();
        bands = bands.stream().filter(band -> band.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        return bands;
    }
}
