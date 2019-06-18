package com.isobar.poc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Track implements Serializable {


    private static final long serialVersionUID = 8483490507789532278L;

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private Integer duration;
}
