package archi.tread.me.grp13.domain.consultant.model;

import archi.tread.me.grp13.domain.ModalitePaiement;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "competences")
    private List<Competence> competences;

    @Column(name = "TJM")
    private Long TarifJournalier;

    @Column(name = "dispo")
    private LocalDate disponibilite;

    @Embedded
    private ModalitePaiement modalitesPaiement;

    public List<Competence> getCompetencesList() {
        return new ArrayList<>();
    }

    public void setCompetencesList(List<Competence> competencesList) {
    }
}
