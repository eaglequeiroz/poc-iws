package com.isobar.poc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Album implements Serializable {

    private static final long serialVersionUID = 6241982327602212448L;

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String image;

    @NonNull
    private String band;

    @NonNull
    private Date releasedDate;

    private Track[] tracks;
}
