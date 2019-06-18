package com.isobar.poc.repository;

import com.isobar.poc.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandRepository extends JpaRepository<Band, String> {
    List<Band> findByNameStartsWithOrderByNameAsc(String name);
}
