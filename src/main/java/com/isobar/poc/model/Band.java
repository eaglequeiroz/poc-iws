package com.isobar.poc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Band implements Serializable {

    private static final long serialVersionUID = -2055851982233863892L;

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String image;

    @NonNull
    private String genre;

    @NonNull
    private String biography;

    @NonNull
    private Integer numPlays;

    @NonNull
    private String[] albums;

    private Album[][] albumList;

}
