package com.isobar.poc.repository;

import com.isobar.poc.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Repository
@Cacheable(value = {"bands"})
public class BandRepository {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${externalUrl}")
    private String externalEndpoint;

    public Band[] getRemote() throws RestClientException {
        return restTemplate.getForObject(externalEndpoint, Band[].class);
    }
}
