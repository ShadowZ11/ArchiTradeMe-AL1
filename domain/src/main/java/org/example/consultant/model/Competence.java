package org.example.consultant.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Competence {

    private String nom;
    private String description;
    private int niveau;

}
