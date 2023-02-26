package org.example.consultant.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.ModalitePaiement;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
public final class Consultant {

    private final Long id;
    private String nom;
    private String prenom;
    private String email;
    private List<Competence> competencesList;
    private Long TarifJournalier;
    private LocalDate disponibilite;
    private ModalitePaiement modalitesPaiement;

}
