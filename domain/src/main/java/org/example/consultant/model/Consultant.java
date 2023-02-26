package org.example.consultant.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.ModalitePaiement;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consultant")
public final class Consultant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competences")
    private List<Competence> competences;

    @Column(name = "TJM")
    private Long TarifJournalier;

    @Column(name = "dispo")
    private LocalDate disponibilite;

    @Embedded
    private ModalitePaiement modalitesPaiement;

}
