package com.isobar.poc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album {

    @Id
    private String id;

    private String name;
    private String image;
    private LocalDate releasedDate;
    private String bandId;

    @OneToMany
    private List<Track> tracks;
}
