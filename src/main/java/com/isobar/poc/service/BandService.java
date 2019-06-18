package com.isobar.poc.service;

import com.isobar.poc.model.Band;
import com.isobar.poc.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    private BandRepository bandRepository;

    @Autowired
    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    public List<Band> createRegistersByExternalEndpoint(List<Band> bands) {
        for (Band band : bands) {
            bandRepository.save(band);
        }
        return bands;
    }

    public List<Band> findAll() {
        return bandRepository.findAll();
    }

    public List<Band> findByName(String name) {
        return bandRepository.findByNameStartsWithOrderByNameAsc(name);
    }
}
