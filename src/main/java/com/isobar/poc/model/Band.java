package com.isobar.poc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Band {

    @Id
    private String id;

    private String name;
    private String image;
    private String genre;
    private String biography;
    private Integer numPlays;

    @OneToMany
    private List<Volume> albumList;

}
